plugins {
    id("java")
}

group = "org.kure"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter:3.4.0")
    implementation("org.springframework.boot:spring-boot-starter-security:3.4.0")
    implementation("org.springframework.boot:spring-boot-starter-web:3.4.0")
    implementation("org.springframework.boot:spring-boot-starter-security:3.4.0")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.0")
    implementation("org.springframework:spring-web:6.2.0")
    implementation("org.hsqldb:hsqldb:2.7.4")
    implementation("org.hibernate.orm:hibernate-core:6.6.3.Final")
    implementation("jakarta.mail:jakarta.mail-api:2.1.3")
    implementation("com.icegreen:greenmail:2.1.2")

    implementation("org.apache.logging.log4j:log4j-api:2.24.2")
    implementation("org.apache.logging.log4j:log4j-core:2.24.2")


    testImplementation("org.springframework.boot:spring-boot-starter-test:3.4.0")
    testImplementation(platform("org.junit:junit-bom:5.11.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.14.2")
    testImplementation("com.mysql:mysql-connector-j:9.1.0")

}


tasks.test {
    useJUnitPlatform()
    systemProperty("buildDir", layout.buildDirectory.get().asFile.absolutePath)
}