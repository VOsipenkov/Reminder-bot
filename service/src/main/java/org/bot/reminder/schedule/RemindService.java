package org.bot.reminder.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.model.Task;
import org.bot.reminder.repository.TaskRepository;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDate;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.bot.reminder.model.Repeat.EVERY_DAY;
import static org.bot.reminder.model.Repeat.EVERY_WEEK;

@Slf4j
@Component
@RequiredArgsConstructor
public class RemindService {
    private final TaskRepository taskRepository;

    public List<Message> remindSingle() {
        var tasks = taskRepository
            .findByDayOfWeekAndIsRepeatable(LocalDate.now().getDayOfWeek().toString(), Boolean.FALSE.toString());

        var messages = tasks.parallelStream()
            .map(this::createMessageUsingTask)
            .collect(toList());

        taskRepository.deleteAll(tasks);
        return messages;
    }

    public List<Message> remindRegular() {
        String dayOfWeekToday = LocalDate.now().getDayOfWeek().toString();
        var tasks = taskRepository
            .findByRepeatTypeIsNotNullAndRepeatTypeInAndIsRepeatable(
                List.of(EVERY_WEEK.toString(), EVERY_DAY.toString()), Boolean.TRUE.toString());

        return tasks.stream()
            .filter(task -> {
                if (task.getRepeatType().equals(EVERY_WEEK)) {
                    return dayOfWeekToday.equals(task.getDayOfWeek());
                }
                return true;
            })
            .map(this::createMessageUsingTask).collect(toList());
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
