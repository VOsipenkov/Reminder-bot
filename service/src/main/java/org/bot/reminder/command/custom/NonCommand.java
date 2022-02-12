package org.bot.reminder.command.custom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.message.MessageReader;
import org.bot.reminder.message.MessageWriter;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor
public class NonCommand {
    private final MessageReader messageReader;
    private final MessageWriter messageWriter;

    public Message processMessage(Update update) {
        log.info("Start processing message {}", update.getMessage().getText());
        var message = update.getMessage();
        var result = messageReader.readMessage(message);
        return  messageWriter.responseMessage(result, message);
    }
}
