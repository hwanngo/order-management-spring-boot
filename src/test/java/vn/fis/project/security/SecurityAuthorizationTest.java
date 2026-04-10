package vn.fis.project.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.context.annotation.Import;
import vn.fis.project.config.WebSecurityConfig;
import vn.fis.project.controller.api.AuthApi;
import vn.fis.project.controller.api.DashboardApi;
import vn.fis.project.controller.api.OrderApi;
import vn.fis.project.controller.api.OrderLineApi;
import vn.fis.project.entity.Role;
import vn.fis.project.entity.User;
import vn.fis.project.jwt.CustomUserDetails;
import vn.fis.project.jwt.JwtTokenProvider;
import vn.fis.project.service.impl.UserDetailsServiceImpl;
import vn.fis.project.service.intf.OrderLineService;
import vn.fis.project.service.intf.OrderService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = {AuthApi.class, DashboardApi.class, OrderApi.class, OrderLineApi.class})
@Import(WebSecurityConfig.class)
class SecurityAuthorizationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @MockBean
    private OrderLineService orderLineService;

    @MockBean(name = "userDetailsServiceImpl")
    private UserDetailsServiceImpl userDetailsService;

    @MockBean
    private AuthenticationManager authenticationManager;

    @MockBean
    private JwtTokenProvider tokenProvider;

    @Test
    void anonymous_user_cannot_access_api_order_listall() throws Exception {
        mockMvc.perform(get("/api/order/listall"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    @WithMockUser(authorities = {"ROLE_SALE"})
    void sale_user_cannot_access_manager_endpoint() throws Exception {
        mockMvc.perform(get("/api/dashboard/total"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(authorities = {"ROLE_MANAGER"})
    void manager_user_can_access_manager_endpoint() throws Exception {
        mockMvc.perform(get("/api/dashboard/total"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(authorities = {"ROLE_SALE"})
    void sale_user_can_update_order_line() throws Exception {
        String body = "{\"id\":1,\"product\":\"Test Product\",\"amount\":1000,\"quantity\":1,\"orderId\":1}";

        mockMvc.perform(post("/api/order/orderline/update")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());
    }

    @Test
    void auth_endpoint_is_not_rejected_for_missing_csrf_token() throws Exception {
        Role role = new Role();
        role.setRoleName("ROLE_ADMIN");

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("encoded");
        user.setRoles(roles);

        CustomUserDetails principal = new CustomUserDetails();
        principal.setUser(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                principal,
                null,
                Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
        );

        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(authentication);
        when(tokenProvider.generateToken(principal)).thenReturn("mock-jwt");

        String body = "{\"username\":\"invalid\",\"password\":\"invalid\"}";

        int status = mockMvc.perform(post("/auth")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andReturn()
                .getResponse()
                .getStatus();

        assertNotEquals(403, status);
    }
}
