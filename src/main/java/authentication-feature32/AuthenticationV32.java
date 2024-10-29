 ```java
// code-start
package com.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Map;

@SpringBootApplication
@CrossOrigin
public class LoginApplication {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplication.class, args);
    }
}

@RestController
@Validated
class LoginController {

    private static final String LOGIN_URL = "/login";

    @PostMapping(LOGIN_URL)
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> userCredentials) {
        // Validate user input
        if (userCredentials == null || userCredentials.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("User credentials are missing.");
        }

        String username = userCredentials.get("username");
        String password = userCredentials.get("password");

        // Security: Avoid hardcoding sensitive information
        // Replace with proper user authentication mechanism
        if (!"admin".equals(username) || !password.equals("password")) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials.");
        }

        // Security: Avoid revealing sensitive information
        return ResponseEntity
                .ok("User logged in successfully.");
    }
}
// code-end
```