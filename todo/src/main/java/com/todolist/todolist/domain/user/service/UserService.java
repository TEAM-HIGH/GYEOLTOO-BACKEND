package com.todolist.todolist.domain.user.service;

import com.todolist.todolist.domain.user.UserRole;
import com.todolist.todolist.domain.user.dto.request.UserRequest;
import com.todolist.todolist.domain.user.dto.response.UserResponse;
import com.todolist.todolist.domain.user.entity.UserEntity;
import com.todolist.todolist.domain.user.repository.UserRepository;
import com.todolist.todolist.global.jwt.JwtTokenProvider;
import com.todolist.todolist.global.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final RedisService redisService;

    @Transactional
    public UserResponse login(UserRequest userRequestDto) {
//        //이렇게 작성하면 사용자 이름만 존재 여부를 판단함.
//        if(!userRepository.existsByUsername(userRequestDto.getUsername())) {
//            throw new IllegalArgumentException("Username not found");
//        }
          //이렇게 하면 사용자 이름 여부와 userentity 객체 가져올 수 있음
          UserEntity userEntity = userRepository.findByUsername(userRequestDto.getUsername())
                  .orElseThrow(()-> new IllegalArgumentException("사용자 존재하지 않음"));

          if(!passwordEncoder.matches(userRequestDto.getPassword(), userEntity.getPassword())){
              throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
          }

          String accessToken = jwtTokenProvider.createAccessToken(userEntity.getUsername(), userEntity.getRole());
          String refreshToken = jwtTokenProvider.createRefreshToken(userEntity.getUsername());

          redisService.setValues(
                  userEntity.getUsername(),
                  refreshToken,
                  Duration.ofDays(14)
          );

          return new UserResponse(accessToken, refreshToken);
    }

    @Transactional
    public void signup(UserRequest userRequestDto) {

        String username = userRequestDto.getUsername();
        String password = passwordEncoder.encode(userRequestDto.getPassword());

        if(userRepository.existsByUsername(userRequestDto.getUsername())){
            throw new IllegalArgumentException("해당 이름으로 가입된 사용자가 있습니다.");
        }

        UserEntity userEntity = UserEntity.builder()
                .username(username)
                .password(password)
                .Role(UserRole.USER)
                .build();

        userRepository.save(userEntity);
    }

}
