package org.bot.reminder.message;

import lombok.RequiredArgsConstructor;
import org.bot.reminder.dictionary.DayOfWeekDictionary;
import org.bot.reminder.dictionary.RepeatableDictionary;
import org.bot.reminder.util.TextPrepareService;
import org.jvnet.hk2.annotations.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DateFormatService {
    private final TextPrepareService textPrepareService;

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
        return RepeatableDictionary.getRepeatable(value).toString();
    }
}
