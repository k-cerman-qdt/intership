package org.kure.example7;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "org.kure.example7.storage.entities")
@EnableJpaRepositories(basePackages = "org.kure.example7.database")
@ComponentScan(basePackages = "org.kure.example7")
public class TestConfig {
}