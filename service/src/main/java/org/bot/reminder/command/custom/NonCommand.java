package org.bot.reminder.command.custom;

import org.bot.reminder.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class NonCommand {
    private final MessageProcessorService messageProcessorService;

    @Autowired
    public NonCommand(MessageProcessorService messageProcessorService) {
        this.messageProcessorService = messageProcessorService;
    }

    public void processMessage(Update update) {
        messageProcessorService.prepareMessage(update.getMessage().getText());
        messageProcessorService.processMessage(update.getMessage().getText());
    }
}
