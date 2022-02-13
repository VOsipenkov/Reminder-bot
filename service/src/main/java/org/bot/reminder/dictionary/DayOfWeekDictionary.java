package org.bot.reminder.dictionary;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

import static java.time.DayOfWeek.*;

public class DayOfWeekDictionary {
    private static final Map<String, DayOfWeek> dayOfWeekMap = new HashMap<>();

    static {
        //Понедельник Monday
        dayOfWeekMap.put("Пн", MONDAY);
        dayOfWeekMap.put("пн", MONDAY);
        dayOfWeekMap.put("понедельник", MONDAY);
        dayOfWeekMap.put("Понедельник", MONDAY);

        //Вторник Tuesday
        dayOfWeekMap.put("Вт", THURSDAY);
        dayOfWeekMap.put("вт", THURSDAY);
        dayOfWeekMap.put("Вторник", THURSDAY);
        dayOfWeekMap.put("вторник", THURSDAY);

        //Среда Wednesday
        dayOfWeekMap.put("Ср", WEDNESDAY);
        dayOfWeekMap.put("ср", WEDNESDAY);
        dayOfWeekMap.put("Среда", WEDNESDAY);
        dayOfWeekMap.put("среда", WEDNESDAY);

        //Четверг Thursday
        dayOfWeekMap.put("Чт", THURSDAY);
        dayOfWeekMap.put("чт", THURSDAY);
        dayOfWeekMap.put("Четверг", THURSDAY);
        dayOfWeekMap.put("четверг", THURSDAY);

        //Пятница Friday
        dayOfWeekMap.put("Пт", FRIDAY);
        dayOfWeekMap.put("пт", FRIDAY);
        dayOfWeekMap.put("пятница", FRIDAY);
        dayOfWeekMap.put("Пятница", FRIDAY);

        //Суббота Saturday
        dayOfWeekMap.put("Сб", SATURDAY);
        dayOfWeekMap.put("сб", SATURDAY);
        dayOfWeekMap.put("суббота", SATURDAY);
        dayOfWeekMap.put("Суббота", SATURDAY);

        //Воскресение Sunday
        dayOfWeekMap.put("Вс", SUNDAY);
        dayOfWeekMap.put("вс", SUNDAY);
        dayOfWeekMap.put("Вскр", SUNDAY);
        dayOfWeekMap.put("вскр", SUNDAY);
        dayOfWeekMap.put("воскресение", SUNDAY);
        dayOfWeekMap.put("Воскресение", SUNDAY);
        dayOfWeekMap.put("Воскресенье", SUNDAY);
        dayOfWeekMap.put("воскресенье", SUNDAY);
    }

    public static DayOfWeek getDayOfWeek(String message) {
        String[] words = message.split(" ");
        for (String word : words) {
            if (dayOfWeekMap.containsKey(word)) {
                return dayOfWeekMap.get(word);
            }
        }
        return null;
    }
}
