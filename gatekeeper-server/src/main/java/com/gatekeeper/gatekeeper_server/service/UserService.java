package com.gatekeeper.gatekeeper_server.service;

import com.gatekeeper.gatekeeper_server.entity.UserEntity;
import com.gatekeeper.gatekeeper_server.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity findByUsername(String username) {

        Optional<UserEntity> user = userRepository.findByUsername(username);

//        return user.orElseThrow(() -> new UserNotFoundException("User not found", 404));
        return user.orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    }
}
