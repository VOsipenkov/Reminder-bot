package org.bot.reminder.command.custom;

import lombok.RequiredArgsConstructor;
import org.bot.reminder.MessageProcessorService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class NonCommand {
    private final MessageProcessorService messageProcessorService;

    public void processMessage(Update update) {
        messageProcessorService.prepareMessage(update.getMessage().getText());
        messageProcessorService.processMessage(update.getMessage().getText());
    }
}
