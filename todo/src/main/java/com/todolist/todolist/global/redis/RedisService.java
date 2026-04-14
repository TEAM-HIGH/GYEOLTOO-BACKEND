package com.todolist.todolist.global.redis;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisService {

    // 스프링이 제공하는 Redis 조작 도구 (Repository의 역할을 대신함)
    private final StringRedisTemplate redisTemplate;

    // 1. 데이터 저장 (TTL 설정 포함)
    public void setValues(String key, String refreshToken, Duration duration) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set(key, refreshToken, duration);
        log.info("리프레스 토큰 저장 완료! {}", refreshToken);
    }

    // 2. 데이터 조회
    public String getValues(String key) {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        return values.get(key);
    }

    // 3. 데이터 삭제
    public void deleteValues(String key) {
        redisTemplate.delete(key);
    }
}
