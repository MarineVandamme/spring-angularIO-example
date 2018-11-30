package com.devlog.soaproject.core.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@PropertySource("classpath:jdbc.properties")
@Configuration
@EnableJpaRepositories({"com.devlog.soaproject.core.repository"})
@EntityScan({"entity"})
public class JdbcConfiguration {
}
