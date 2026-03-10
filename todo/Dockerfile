# 1. 자바 17 환경을 가져옵니다.
FROM openjdk:17-jdk-slim

# 2. 내 컴퓨터의 빌드된 jar 파일을 컨테이너 안에 넣습니다.
COPY build/libs/*.jar app.jar

# 3. 서버가 띄워질 때 실행할 명령어입니다.
ENTRYPOINT ["java", "-jar", "/app.jar"]