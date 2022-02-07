package org.bot.reminder.command.custom;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.MessageProcessorService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
@RequiredArgsConstructor
public class NonCommand {
    private final MessageProcessorService messageProcessorService;

    public void processMessage(Update update) {
        log.info("NonCommand invoked with message {}", update.getMessage().getText());
        messageProcessorService.prepareMessage(update.getMessage().getText());
        messageProcessorService.processMessage(update.getMessage().getText());
    }
}
