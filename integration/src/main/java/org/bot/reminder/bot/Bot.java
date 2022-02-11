package org.bot.reminder.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.command.custom.NonCommand;
import org.bot.reminder.command.service.HelpCommand;
import org.bot.reminder.command.service.StartCommand;
import org.bot.reminder.property.BotParams;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingCommandBot {
    private final NonCommand nonCommand;
    private final BotParams botParams;

    @PostConstruct
    public void registerCommand() {
        this.register(new StartCommand("Start", "Старт"));
        this.register(new HelpCommand("Help", "Помощь"));
        log.info("Service commands registered");
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
        var message = nonCommand.processMessage(update);
        sendAnswer(update.getMessage().getChatId(),
            null,
            update.getMessage().getFrom().getUserName(),
            "Зарегистрировано " + message.getText());
    }

    @Override
    public String getBotToken() {
        return botParams.getToken();
    }

    private void sendAnswer(Long chatId, String commandName, String userName, String text) {
        var message = SendMessage.builder()
            .text(text)
            .chatId(chatId.toString()).build();
        message.enableMarkdown(true);
        try {
            this.execute(message);
        } catch (TelegramApiException e) {
            log.error("ServiceCommand error for user {}, with text {}", userName, text);
            e.printStackTrace();
        }
    }
}
