package org.bot.reminder.config;

import org.bot.reminder.bot.Bot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
@ComponentScan("org.bot.reminder.bot")
public class BotConfig {

    @Bean
    public TelegramBotsApi telegramBots(Bot bot) throws TelegramApiException {
        var bots = new TelegramBotsApi(DefaultBotSession.class);
        bots.registerBot(bot);
        return bots;
    }
}
