package org.kure.example6;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;

@Configuration
@EntityScan(basePackages = "org.kure.example6.storage.entities")
@EnableJpaRepositories(basePackages = "org.kure.example6.database")
@ComponentScan(basePackages = "org.kure.example6")
public class TestConfig {
}
