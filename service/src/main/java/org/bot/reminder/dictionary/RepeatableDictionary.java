package org.bot.reminder.dictionary;

import org.bot.reminder.model.Repeat;

import java.util.HashMap;
import java.util.Map;

import static org.bot.reminder.model.Repeat.*;

public class RepeatableDictionary {
    private static final Map<String, Repeat> mapRepeatable = new HashMap<>();

    static {
        // EVERY DAY
        mapRepeatable.put("Eжедневно", EVERY_DAY);
        mapRepeatable.put("Eжедневн", EVERY_DAY);
        mapRepeatable.put("Ежеднев", EVERY_DAY);
        mapRepeatable.put("Ежедн", EVERY_DAY);
        mapRepeatable.put("ежедневно", EVERY_DAY);
        mapRepeatable.put("ежедневн", EVERY_DAY);
        mapRepeatable.put("ежедн", EVERY_DAY);
        mapRepeatable.put("Каждый день", EVERY_DAY);
        mapRepeatable.put("Каждый День", EVERY_DAY);
        mapRepeatable.put("каждый День", EVERY_DAY);
        mapRepeatable.put("каждый день", EVERY_DAY);
        // EVERY_WEEK
        mapRepeatable.put("Еженедельно", EVERY_WEEK);
        mapRepeatable.put("Еженедельн", EVERY_WEEK);
        mapRepeatable.put("Еженедель", EVERY_WEEK);
        mapRepeatable.put("Еженед", EVERY_WEEK);
        mapRepeatable.put("еженедельно", EVERY_WEEK);
        mapRepeatable.put("еженедельн", EVERY_WEEK);
        mapRepeatable.put("еженедель", EVERY_WEEK);
        mapRepeatable.put("еженед", EVERY_WEEK);
        mapRepeatable.put("Каждую неделю", EVERY_WEEK);
        mapRepeatable.put("каждую неделю", EVERY_WEEK);
        mapRepeatable.put("Каждую Неделю", EVERY_WEEK);
        mapRepeatable.put("каждую Неделю", EVERY_WEEK);
        //EVERY_MONTH
        mapRepeatable.put("Ежемесячно", EVERY_MONTH);
        mapRepeatable.put("Ежемесично", EVERY_MONTH);
        mapRepeatable.put("Ежемесечн", EVERY_MONTH);
        mapRepeatable.put("Ежемесеч", EVERY_MONTH);
        mapRepeatable.put("Ежемесч", EVERY_MONTH);
        mapRepeatable.put("Ежемес", EVERY_MONTH);
        mapRepeatable.put("Ежмес", EVERY_MONTH);
        mapRepeatable.put("ежемесячно", EVERY_MONTH);
        mapRepeatable.put("ежемесично", EVERY_MONTH);
        mapRepeatable.put("ежемесечн", EVERY_MONTH);
        mapRepeatable.put("ежемесеч", EVERY_MONTH);
        mapRepeatable.put("ежемесч", EVERY_MONTH);
        mapRepeatable.put("ежемес", EVERY_MONTH);
        mapRepeatable.put("ежмес", EVERY_MONTH);
        mapRepeatable.put("Каждый месяц", EVERY_MONTH);
        mapRepeatable.put("Каждый Месяц", EVERY_MONTH);
        mapRepeatable.put("каждый месяц", EVERY_MONTH);
        mapRepeatable.put("каждый Месяц", EVERY_MONTH);
    }

    public static Repeat getRepeatable(String message) {
        String[] words = message.split(" ");
        for (String word : words) {
            if (mapRepeatable.containsKey(word)) {
                return mapRepeatable.get(word);
            }
        }
        return null;
    }
}
