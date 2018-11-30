package com.devlog.soaproject.web;

import com.devlog.soaproject.core.configuration.CoreConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({CoreConfiguration.class})
@EntityScan({"com.devlog.soaproject.entity"})
@ComponentScan//({"com.devlog.soaproject.web.controller"})
public class SoaProjectConfiguration {
}
