plugins {
	java
	war
	id("org.springframework.boot") version "3.4.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.lls"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(22)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.4.2")
	implementation("org.jsoup:jsoup:1.18.3")
	implementation("software.amazon.awssdk:dynamodb:2.30.11")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat:3.4.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.2")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.11.4")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
