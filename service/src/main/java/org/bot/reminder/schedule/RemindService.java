package org.bot.reminder.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.Task;
import org.bot.reminder.repository.TaskRepository;
import org.bot.reminder.repository.UserInfoRepository;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static org.bot.reminder.model.Repeat.EVERY_DAY;
import static org.bot.reminder.model.Repeat.EVERY_WEEK;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemindService {
    private final TaskRepository taskRepository;
    private final UserInfoRepository userInfoRepository;

    public List<Message> remindSingle() {
        var tasks = taskRepository
            .findByDayOfWeekAndIsRepeatableFalse(LocalDate.now().getDayOfWeek().toString());

        var messages = tasks.parallelStream()
            .map(this::createMessageUsingTask)
            .collect(Collectors.toList());

        taskRepository.deleteAll(tasks);
        return messages;
    }

    public List<Message> remindRegular() {
        String dayOfWeekToday = LocalDate.now().getDayOfWeek().toString();
        var tasks = taskRepository
            .findByIsRepeatableAndRepeatTypeIsNotNullAndRepeatTypeIn(List.of(EVERY_WEEK.toString(), EVERY_DAY.toString()));

        return tasks.stream()
            .filter(task -> {
                if (task.getRepeatType().equals(EVERY_WEEK)) {
                    return dayOfWeekToday.equals(task.getDayOfWeek());
                }
                return true;
            })
            .map(this::createMessageUsingTask).collect(Collectors.toList());
    }

    private Message createMessageUsingTask(Task task) {
        var message = new Message();
        message.setText(task.getAction());

        var chat = new Chat();
        chat.setId(task.getChatId());
        message.setChat(chat);

        var user = new User();
        user.setUserName(task.getUserInfo().getUserName());
        user.setFirstName(task.getUserInfo().getUserName());
        user.setLastName(task.getUserInfo().getLastName());
        message.setFrom(user);
        return message;
    }
}
