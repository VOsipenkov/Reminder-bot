package org.bot.reminder.command.service;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

@Slf4j
public class HelpCommand extends ServiceCommand {
    private static final String HELP_MESSAGE = "Тут будут команды в каком-то виде";

    public HelpCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        log.info("StartCommand invoked by username {}, firstname {}, lastname {}",
            user.getUserName(), user.getFirstName(), user.getLastName());
        sendAnswer(absSender, user.getId(), this.getCommandIdentifier(), user.getUserName(), HELP_MESSAGE);
    }
}
