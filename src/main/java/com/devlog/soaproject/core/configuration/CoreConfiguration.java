package com.devlog.soaproject.core.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@PropertySource("classpath:application.properties")
@Configuration
@EnableTransactionManagement
@ComponentScan({"com.devlog.soaproject.core.service",
        "com.devlog.soaproject.core.service.impl",
        "com.devlog.soaproject.core.repository",
        "com.devlog.soaproject.core.configuration"})
@Import({JdbcConfiguration.class})
public class CoreConfiguration {
}
