package com.gatekeeper.gatekeeper_server.config;

import com.gatekeeper.gatekeeper_server.entity.UserEntity;
import com.gatekeeper.gatekeeper_server.service.UserService;
import com.gatekeeper.gatekeeper_server.utils.enums.Permissions;
import com.gatekeeper.gatekeeper_server.utils.enums.UserRoles;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminAccountSeeder implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AdminAccountSeeder(
            UserService userService,
            PasswordEncoder passwordEncoder
    ) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        UserEntity existingUser = userService.findByUsername("admin");
        if (existingUser != null) {
            return;
        }
        UserEntity user = new UserEntity();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRole(UserRoles.ADMIN);
        user.setPermissions(Permissions.WRITE);
        userService.save(user);
    }
}
