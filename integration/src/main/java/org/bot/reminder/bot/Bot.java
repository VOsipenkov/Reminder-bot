package org.bot.reminder.bot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.command.custom.NonCommand;
import org.bot.reminder.command.service.HelpCommand;
import org.bot.reminder.command.service.StartCommand;
import org.bot.reminder.property.BotParams;
import org.bot.reminder.schedule.RemindService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingCommandBot {
    private final NonCommand nonCommand;
    private final RemindService remindService;
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
        sendAnswer(message);
    }

    //    //9 o'clock of every day
    //    @Scheduled(cron = "0 0 9 * * *")//prod config
    //"*/10 * * * * *"  every 100 sec
    @Scheduled(cron = "*/100 * * * * *")//test config
    public void notification() {
        log.info("Notification started");
        List<Message> messages = remindService.remindSingle();
        messages.forEach(this::sendAnswer);

        messages = remindService.remindRegular();
        messages.forEach(this::sendAnswer);
        log.info("Notification completed");
    }

    @Override
    public String getBotToken() {
        return botParams.getToken();
    }

    private void sendAnswer(Message message) {
        var chatId = message.getChatId();
        var userName = message.getFrom().getUserName();
        var text = "Зарегистрировано " + message.getText();

        log.info("Send response to {}", userName);
        var response = SendMessage.builder()
            .text(text)
            .chatId(chatId.toString()).build();
        response.enableMarkdown(true);
        try {
            this.execute(response);
        } catch (TelegramApiException e) {
            log.error("ServiceCommand error for user {}, with text {}", userName, text);
            e.printStackTrace();
        }
    }
}
