package com.publiko.api.security;

import com.publiko.api.user.entity.UserEntity;
import com.publiko.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username)
            .orElseThrow(() -> {
                log.error("User not found: {}", username);
                return new UsernameNotFoundException(("Could not found user."));
            });

        log.info("Success to find a user with username: {}", username);

        return User.builder().username(userEntity.getId()).roles("USER").build();
    }
}
