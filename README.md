# Spring Guide Demo Project

이 프로젝트는 Spring Boot 기본 가이드를 연습하기 위한 데모 프로젝트입니다. 학습용으로 구성되어 있으며, 간단한 애플리케이션 뼈대와 빌드 설정을 포함합니다.

- **프로젝트 그룹**: `com.jokim`
- **버전**: `0.0.1-SNAPSHOT`
- **설명**: Demo project for Spring Boot
- **애플리케이션 이름**: `demo` (application.properties의 `spring.application.name`)

## 사용된 주요 스펙

- Spring Boot Gradle Plugin: `org.springframework.boot` version `3.5.6`
- Dependency management plugin: `io.spring.dependency-management` version `1.1.7`
- Java toolchain: Java `25` (build.gradle의 `JavaLanguageVersion.of(25)`)
- 주요 의존성:
  - `org.springframework.boot:spring-boot-starter`
  - `org.springframework.boot:spring-boot-starter-test` (테스트)
  - `org.junit.platform:junit-platform-launcher` (테스트 런타임)

## 프로젝트 구조

```text
/ (루트)
├─ build.gradle
├─ settings.gradle
├─ src/main/java/com/jokim/demo/DemoApplication.java
├─ src/main/resources/application.properties
└─ src/test/java/.../DemoApplicationTests.java
```

## 실행 방법

1. 로컬에 JDK 25가 설정되어 있거나 Gradle toolchain이 이를 관리하도록 설정되어 있어야 합니다.
1. 프로젝트 루트에서 Gradle wrapper를 사용하여 실행:

```bash
./gradlew bootRun
```

1. 테스트 실행:

```bash
./gradlew test
```

## 목적

이 저장소는 **Spring Boot 입문과 실습을 위한 가이드용 예제**입니다. 다음을 연습하기에 적합합니다:

- **애플리케이션 구조 이해**: Spring Boot의 기본 패키지/클래스 배치
- **의존성 관리와 Gradle 설정**: 플러그인 및 toolchain 설정
- **기본 기능 추가 및 테스트**: REST 컨트롤러, 서비스, 리포지토리, 단위/통합 테스트

원하시면 예제 컨트롤러, 서비스, 테스트 케이스를 직접 추가해드리겠습니다.
