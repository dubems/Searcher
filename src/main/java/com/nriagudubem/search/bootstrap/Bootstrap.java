package com.nriagudubem.search.bootstrap;

import com.nriagudubem.search.config.user.Roles;
import com.nriagudubem.search.model.Role;
import com.nriagudubem.search.model.User;
import com.nriagudubem.search.repository.RoleRepository;
import com.nriagudubem.search.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@Slf4j
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    @Transactional
    public void run(String... args) {
        String email = "dubem@gmail.com";
        try {
            userRepository.save(userRepository.findByEmail(email)
                    .orElse(createUser(email)));
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }

    }

    private User createUser(String email) throws Exception {
        createRoles();
        User.UserBuilder userBuilder = User.builder()
                .email(email)
                .password(passwordEncoder.encode("password"))
                .createdAt(LocalDate.now())
                .updateAt(LocalDate.now());
        Role adminRole = roleRepository.findByName(Roles.ROLE_ADMIN.name())
                .orElseThrow(() -> new Exception("Cant find admin role"));
        return userBuilder.roles(Stream.of(adminRole)
                .collect(Collectors.toSet()))
                .build();
    }

    private void createRoles() {
        Arrays.stream(Roles.values()).forEach(role ->
            roleRepository.save(Role.builder().name(role.name()).build()));

    }
}
