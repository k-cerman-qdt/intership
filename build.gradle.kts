plugins {
    id("java")
}

group = "org.kure"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("com.mysql:mysql-connector-j:9.1.0")



}

tasks.test {
    useJUnitPlatform()
}