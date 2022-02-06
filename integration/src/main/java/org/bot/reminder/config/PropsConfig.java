package org.bot.reminder.config;

import org.bot.reminder.property.BotParams;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(BotParams.class)
@ConfigurationPropertiesScan(basePackages = "org.bot.reminder.property")
public class PropsConfig {
}
