package org.bot.reminder.processing;

import lombok.RequiredArgsConstructor;
import org.bot.reminder.dictionary.DayOfWeekDictionary;
import org.bot.reminder.dictionary.RepeatableDictionary;
import org.bot.reminder.model.ResultMessage;
import org.bot.reminder.model.Task;
import org.bot.reminder.model.UserInfo;
import org.bot.reminder.util.TextPrepareService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.time.LocalDate;

/**
 * This class split message to userInfo and message-text and save it in objects
 */
@Service
@RequiredArgsConstructor
public class MessageReader {

    private final TextPrepareService textPrepareService;

    public ResultMessage process(Message message) {
        var userInfo = getUserInfo(message);
        var task = getTask(message);
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

        task.setDayOfWeek(DayOfWeekDictionary.getDayOfWeek(values[0]));
        task.setRepeatCycle(RepeatableDictionary.getRepeatable(values[0]));

        var action = new StringBuilder();
        for (int i = 1; i < values.length; i++) {
            action.append(values[i]);
        }
        task.setAction(action.toString());
        task.setDate(LocalDate.now());

        return task;
    }
}
