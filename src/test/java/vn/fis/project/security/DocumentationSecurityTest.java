package vn.fis.project.security;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DocumentationSecurityTest {

    @Test
    void readme_does_not_document_default_plaintext_passwords() throws IOException {
        Path readmePath = Paths.get("README.md");
        String readme = new String(Files.readAllBytes(readmePath), StandardCharsets.UTF_8);

        assertAll(
                () -> assertFalse(readme.contains("admin|admin")),
                () -> assertFalse(readme.contains("manager|manager")),
                () -> assertFalse(readme.contains("sale|sale"))
        );
    }
}
