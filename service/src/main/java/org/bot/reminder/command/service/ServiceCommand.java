package org.bot.reminder.command.service;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
abstract class ServiceCommand extends BotCommand {

    ServiceCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    public void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text) {
        var message = SendMessage.builder()
            .text(text)
            .chatId(chatId.toString()).build();
        message.enableMarkdown(true);
        try {
            absSender.execute(message);
        } catch (TelegramApiException e) {
            log.error("ServiceCommand error for user {}, with text {}", userName, text);
            e.printStackTrace();
        }
    }
}
