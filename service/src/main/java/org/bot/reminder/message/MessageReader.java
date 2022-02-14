package org.bot.reminder.message;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bot.reminder.model.DayOfWeek;
import org.bot.reminder.model.ResultMessage;
import org.bot.reminder.model.Task;
import org.bot.reminder.model.UserInfo;
import org.bot.reminder.parser.LexerScanner;
import org.bot.reminder.parser.Parser;
import org.bot.reminder.parser.dictionary.Token;
import org.bot.reminder.util.TextPrepareService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.Set;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
public class MessageReader {

    private final TextPrepareService textPrepareService;
    private final LexerScanner lexerScanner;

    public ResultMessage readMessage(Message message) {
        var userInfo = getUserInfo(message);
        var task = getTask(message);
        task.setUserInfo(userInfo);
        userInfo.setTask(task);
        return ResultMessage.builder()
            .userInfo(userInfo)
            .task(task).build();
    }

    private UserInfo getUserInfo(Message message) {
        var userName = message.getFrom().getUserName();
        var firstName = message.getFrom().getFirstName();
        var lastName = message.getFrom().getLastName();

        var userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        return userInfo;
    }

    private Task getTask(Message message) {
        var text = message.getText();
        text = textPrepareService.prepareText(text);
        var task = new Task();
        String[] values = text.split("  ");

        Set<Token> tokens = lexerScanner.textScan(values[0]);

        task.setDayOfWeek(Parser.getDaysOfWeek(tokens) != null ?
            Parser.getDaysOfWeek(tokens).stream()
                .map(token -> {
                    var dayOfWeek = new DayOfWeek();
                    dayOfWeek.setValueData(token.toString());
                    dayOfWeek.setTask(task);
                    return dayOfWeek;
                }).collect(Collectors.toList()) : null);

        task.setIsRepeatable(Parser.isRepeatable(tokens) != null ?
            Parser.isRepeatable(tokens).toString() : null);

        task.setRepeatType(Parser.getRepeateType(tokens) != null ?
            Parser.getRepeateType(tokens).toString() : null);

        task.setAction(getAction(values));
        task.setChatId(message.getChatId());

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
