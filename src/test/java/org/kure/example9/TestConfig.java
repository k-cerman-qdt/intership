package org.kure.example9;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"org.kure.example9.storage.entities", "org.kure.example4"})
@EnableJpaRepositories(basePackages = "org.kure.example9.database")
@ComponentScan(basePackages = "org.kure.example9")
public class TestConfig {
}