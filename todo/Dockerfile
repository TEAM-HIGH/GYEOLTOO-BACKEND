# 1단계: 빌드 (JDK 환경에서 소스를 가져와 jar를 직접 만듭니다)
FROM openjdk:17-jdk-slim AS build
WORKDIR /app
# 현재 위치(todo 폴더)의 모든 파일을 컨테이너 안으로 복사
COPY . .
# gradlew에 실행 권한을 주고 빌드 실행
RUN chmod +x ./gradlew
RUN ./gradlew clean build -x test

# 2단계: 실행 (최종 결과물인 jar만 실행합니다)
FROM openjdk:17-jdk-slim
WORKDIR /app
# 1단계에서 빌드된 jar 파일만 쏙 가져오기
COPY --from=build /app/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]