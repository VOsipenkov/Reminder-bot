package org.bot.reminder.processing;

import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.ResultMessage;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageWriter {
    public void responseMessage(ResultMessage resultMessage) {
        log.info("Создано уведомление для {}", resultMessage.getTask().getAction());
        log.info("Уведомление будет показано {}", resultMessage.getTask().getDayOfWeek());
        log.info("Повторяемость {}", resultMessage.getTask().getRepeatCycle());
        log.info("Дата создания {}", resultMessage.getTask().getDate());
        log.info("Для пользователя {} {} {}",
            resultMessage.getUserInfo().getUserName(),
            resultMessage.getUserInfo().getFirstName(),
            resultMessage.getUserInfo().getLastName());
    }
}
