package org.bot.reminder.command.service;

import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class HelpCommand extends ServiceCommand {
    private static final String HELP_MESSAGE = "Тут будут команды в каком-то виде";

    public HelpCommand(String commandIdentifier, String description) {
        super(commandIdentifier, description);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] arguments) {
        sendAnswer(absSender, user.getId(), this.getCommandIdentifier(), user.getUserName(), HELP_MESSAGE);
    }
}
