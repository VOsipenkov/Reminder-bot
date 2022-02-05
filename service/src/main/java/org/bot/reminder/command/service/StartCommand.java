package org.bot.reminder.command.service;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
public class StartCommand extends ServiceCommand {
    private final String START_MESSAGE = "Если у вас возникнут вопросы, воспользуйтесь командой /help";


    public StartCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
//        log.info("StartCommand: execute {} {}", user, chat.toString());
        sendAnswer(absSender, chat.getId(), this.getCommandIdentifier(), user.getUserName(), START_MESSAGE);
    }
}
