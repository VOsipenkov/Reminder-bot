package org.bot.reminder.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@EntityScan(basePackages = "org.bot.reminder.model")
@Configuration
@EnableJpaRepositories(basePackages = "org.bot.reminder.repository")
@EnableTransactionManagement
public class JpaConfig {
}
