package vn.fis.project.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.fis.project.entity.Role;
import vn.fis.project.entity.User;
import vn.fis.project.jwt.CustomUserDetails;
import vn.fis.project.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        User user = userRepository.findById(Math.toIntExact(id)).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        user.setLastLogin(new Date());
        userRepository.save(user);

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        customUserDetails.setAuthorities(grantedAuthorities);

        return customUserDetails;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        user.setLastLogin(new Date());
        userRepository.save(user);

        CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        customUserDetails.setAuthorities(grantedAuthorities);

        return customUserDetails;
    }

}