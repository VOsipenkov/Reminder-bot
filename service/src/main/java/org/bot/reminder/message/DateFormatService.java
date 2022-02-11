package org.bot.reminder.message;

import lombok.Data;
import org.bot.reminder.dictionary.DayOfWeekDictionary;
import org.bot.reminder.dictionary.RepeatableDictionary;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public class DateFormatService {

    public String getDayOfWeek(String value) {
        return DayOfWeekDictionary.getDayOfWeek(value).toString();
    }

    public boolean isRepeatable(String value) {
        return RepeatableDictionary.getRepeatable(value) != null;
    }

    public LocalDate getDayOfYear(String value) {
        //todo not implemented
        return null;
    }

    public String getRepeateType(String value) {
        var repeatableType = RepeatableDictionary.getRepeatable(value);
        return repeatableType != null ? repeatableType.toString() : null;
    }
}
