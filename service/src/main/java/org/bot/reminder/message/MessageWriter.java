package org.bot.reminder.message;

import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.ResultMessage;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Slf4j
@Service
public class MessageWriter {

    public Message responseMessage(ResultMessage resultMessage, Message message) {
        log.info("Task: {}", resultMessage.getTask());
        log.info("UserInfo: {}", resultMessage.getUserInfo());
        message.setText(resultMessage.getTask().getAction() + " назначено на " + resultMessage.getTask().getDayOfWeek());
        return message;
    }
}
