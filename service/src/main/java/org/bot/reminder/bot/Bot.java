package org.bot.reminder.bot;

import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.command.service.StartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Bot extends TelegramLongPollingCommandBot {
    private final NonCommand nonCommand;

    @Autowired
    public Bot(NonCommand nonCommand) {
        super();
        this.nonCommand = nonCommand;
    }

    @PostConstruct
    public void registerCommand() {
        this.register(new StartCommand("Start", "Старт"));
    }

    @Override
    public String getBotUsername() {
        return "reminder";
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
        return "5127684113:AAH5HCBgWbjk8TR2SZOi0mFYiv3RWgWh3Is";
    }
}
