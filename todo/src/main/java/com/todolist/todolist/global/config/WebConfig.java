package com.todolist.todolist.global.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 1. 모든 경로에 대해
                .allowedOrigins("https://gyeoltoo-frontend.vercel.app.com") // 2. 프론트엔드 주소 허용
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 3. 허용할 HTTP 메서드
                .allowedHeaders("*") // 4. 모든 헤더 허용
                .allowCredentials(true) // 5. 쿠키/인증 정보 포함 허용 시 필수
                .maxAge(3600); // 6. 프리플라이트(Preflight) 요청 캐싱 시간
    }
}