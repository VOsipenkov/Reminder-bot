package org.bot.reminder.message;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.ResultMessage;
import org.bot.reminder.repository.TaskRepository;
import org.bot.reminder.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageWriter {

    private final TaskRepository taskRepository;
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public Message responseMessage(ResultMessage resultMessage, Message message) {
        log.info("Task: {}", resultMessage.getTask());
        log.info("UserInfo: {}", resultMessage.getUserInfo());
        save(resultMessage);
        message.setText(resultMessage.getTask().getAction() + " " + resultMessage.getTask().getDayOfWeek());
        return message;
    }

    private void save(ResultMessage resultMessage) {
        taskRepository.save(resultMessage.getTask());
        userInfoRepository.save(resultMessage.getUserInfo());
    }
}
