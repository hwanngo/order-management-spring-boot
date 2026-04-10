package vn.fis.project.security;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BootstrapSecurityTest {

    @Test
    void seed_sql_does_not_contain_plaintext_default_password_hints() throws IOException {
        Path seedSqlPath = Paths.get("src", "main", "resources", "data-mysql.sql");
        String seedSql = new String(Files.readAllBytes(seedSqlPath), StandardCharsets.UTF_8);

        assertAll(
                () -> assertFalse(seedSql.contains("password: admin")),
                () -> assertFalse(seedSql.contains("password: manager")),
                () -> assertFalse(seedSql.contains("password: sale"))
        );
    }
}
