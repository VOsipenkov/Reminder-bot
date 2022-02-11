package org.bot.reminder.command.custom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.message.MessageService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor
public class NonCommand {
    private final MessageService messageService;

    public Message processMessage(Update update) {
        log.info("NonCommand invoked with message {}", update.getMessage().getText());
        return messageService.process(update.getMessage());
    }
}
