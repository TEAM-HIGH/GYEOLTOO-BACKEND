package com.todolist.todolist.global.security;

import com.todolist.todolist.domain.user.entity.UserEntity;
import com.todolist.todolist.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("사용자 존재하지 않음"));

        return new CustomUserDetails(userEntity);
    }

}
