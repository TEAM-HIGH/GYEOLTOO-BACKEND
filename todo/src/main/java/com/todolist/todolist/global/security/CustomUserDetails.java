package com.todolist.todolist.global.security;

import com.todolist.todolist.domain.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {

    private final UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String authority = "ROLE_" + user.getRole().toString();
        return new ArrayList<>(Collections.singletonList(new SimpleGrantedAuthority(authority)));
    }

    // 2. 유저의 비밀번호 반환
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 3. 유저의 고유 식별값(아이디) 반환
    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // --- 아래 메서드들은 계정의 상태를 체크하는 설정입니다 ---
    // 특별한 로직이 없다면 모두 true를 반환해야 로그인이 가능합니다.

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부 (true: 만료 안됨)
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠김 여부 (true: 안잠김)
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 비밀번호 만료 여부 (true: 만료 안됨)
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부 (true: 활성)
    }

    // 추가로 유저 객체 자체가 필요할 때를 대비해 getter를 만들어두면 편합니다.
    public UserEntity getUser() {
        return user;
    }
}
