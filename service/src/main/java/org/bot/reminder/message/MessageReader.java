package org.bot.reminder.message;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bot.reminder.model.ResultMessage;
import org.bot.reminder.model.Task;
import org.bot.reminder.model.UserInfo;
import org.bot.reminder.util.TextPrepareService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Data
@Service
@RequiredArgsConstructor
public class MessageReader {

    private final TextPrepareService textPrepareService;
    private final DateFormatService dateFormatService;

    public ResultMessage readMessage(Message message) {
        var userInfo = getUserInfo(message);
        var task = getTask(message);
        task.setUserInfo(userInfo);
        return ResultMessage.builder()
            .userInfo(userInfo)
            .task(task).build();
    }

    private UserInfo getUserInfo(Message message) {
        var userName = message.getFrom().getUserName();
        var firstName = message.getFrom().getFirstName();
        var lastName = message.getFrom().getLastName();
        return UserInfo.builder()
            .userName(userName)
            .firstName(firstName)
            .lastName(lastName).build();
    }

    private Task getTask(Message message) {
        var text = message.getText();
        text = textPrepareService.prepareText(text);
        var task = new Task();
        String[] values = text.split("  ");

        task.setDayOfWeek(dateFormatService.getDayOfWeek(values[0]));
        task.setDayOfYear(dateFormatService.getDayOfYear(values[0]));
        task.setIsRepeatable(dateFormatService.isRepeatable(values[0]));
        task.setRepeatType(dateFormatService.getRepeateType(values[0]));
        task.setAction(getAction(values));

        return task;
    }

    private String getAction(String[] messages) {
        var action = new StringBuilder();
        for (int i = 1; i < messages.length; i++) {
            action.append(messages[i]);
        }
        return action.toString();
    }
}
