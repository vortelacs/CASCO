plugins {
    java
    id("org.springframework.boot") version "3.0.1"
    id("io.spring.dependency-management") version "1.1.0"
    id("org.graalvm.buildtools.native") version "0.9.18"
}

group = "com.asig"
version = "0.0.1-SNAPSHOT"

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.thymeleaf:thymeleaf:3.1.1.RELEASE")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation("org.springframework.security:spring-security-web:6.0.2")
    implementation("org.springframework.security:spring-security-config:6.0.2")
    implementation("org.springframework.security:spring-security-core:6.0.2")
    implementation("org.springframework.boot:spring-boot-starter-tomcat:3.0.6")
    implementation("org.hibernate:hibernate-core:6.2.2.Final")
    implementation("org.hibernate.orm:hibernate-entitymanager:6.0.0.Alpha7")
    implementation("jakarta.persistence:jakarta.persistence-api:3.1.0")
    implementation("org.springframework:spring-jdbc:6.0.7")
    compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("org.springframework.data:spring-data-jpa:3.0.3")
    implementation("org.xhtmlrenderer:flying-saucer-pdf:9.1.22")
    testImplementation("com.h2database:h2:2.1.214")
    implementation("javax.persistence:javax.persistence-api:2.2")
    implementation("javax.validation:validation-api:2.0.1.Final")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
