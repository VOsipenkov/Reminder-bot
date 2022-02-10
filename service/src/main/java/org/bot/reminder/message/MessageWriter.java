package org.bot.reminder.message;

import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.ResultMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageWriter {

    public void responseMessage(ResultMessage resultMessage) {
        log.info("Task: {}", resultMessage.getTask());
        log.info("UserInfo: {}", resultMessage.getUserInfo());
    }
}
