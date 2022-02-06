package org.bot.reminder.bot;

import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.command.custom.NonCommand;
import org.bot.reminder.command.service.StartCommand;
import org.bot.reminder.property.BotParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Bot extends TelegramLongPollingCommandBot {
    private final NonCommand nonCommand;
    private final BotParams botParams;
    private ApplicationContext applicationContext;

    @Autowired
    public Bot(NonCommand nonCommand, BotParams botParams, ApplicationContext applicationContext) {
        super();
        this.nonCommand = nonCommand;
        this.botParams = botParams;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void registerCommand() {
        this.register(new StartCommand("Start", "Старт"));
    }

    @Override
    public String getBotUsername() {
        return botParams.getUserName();
    }

    /**
     * Логика обработки текстовых сообщений, не являющихся командами
     */
    @Override
    public void processNonCommandUpdate(Update update) {
        int i = 1;
    }

    @Override
    public String getBotToken() {
        return botParams.getToken();
    }
}
