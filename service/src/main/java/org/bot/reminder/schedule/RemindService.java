package org.bot.reminder.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.repository.TaskRepository;
import org.bot.reminder.repository.UserInfoRepository;
import org.jvnet.hk2.annotations.Service;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class RemindService {
    private final TaskRepository taskRepository;
    private final UserInfoRepository userInfoRepository;

    public List<Message> remindSingle() {
        var tasks = taskRepository
            .findByDayOfWeekAndIsRepeatableFalse(LocalDate.now().getDayOfWeek().toString());
        return tasks.parallelStream().map(task -> {
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
        }).collect(Collectors.toList());
    }

    public void remindRegular() {

    }
}
