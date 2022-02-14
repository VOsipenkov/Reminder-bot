package org.bot.reminder.parser.dictionary;

import java.util.HashMap;
import java.util.Map;

import static org.bot.reminder.parser.dictionary.Token.*;

public class DayOfWeekDictionary {
    private static final Map<String, Token> dayOfWeekMap = new HashMap<>();

    static {
        //Понедельник Monday
        dayOfWeekMap.put("пн", MONDAY);
        dayOfWeekMap.put("пон", MONDAY);
        dayOfWeekMap.put("понедел", MONDAY);
        dayOfWeekMap.put("понедельник", MONDAY);
        dayOfWeekMap.put("понедельника", MONDAY);
        dayOfWeekMap.put("понедельнику", MONDAY);
        dayOfWeekMap.put("понедельником", MONDAY);
        dayOfWeekMap.put("понедельнике", MONDAY);
        dayOfWeekMap.put("понедельники", MONDAY);
        dayOfWeekMap.put("понедельников", MONDAY);

        //Вторник Tuesday
        dayOfWeekMap.put("вт", THURSDAY);
        dayOfWeekMap.put("вторник", THURSDAY);
        dayOfWeekMap.put("вторника", THURSDAY);
        dayOfWeekMap.put("вторнику", THURSDAY);
        dayOfWeekMap.put("вторником", THURSDAY);
        dayOfWeekMap.put("вторнике", THURSDAY);
        dayOfWeekMap.put("вторникам", THURSDAY);
        dayOfWeekMap.put("вторников", THURSDAY);

        //Среда Wednesday
        dayOfWeekMap.put("ср", WEDNESDAY);
        dayOfWeekMap.put("сред", WEDNESDAY);
        dayOfWeekMap.put("среда", WEDNESDAY);
        dayOfWeekMap.put("среду", WEDNESDAY);
        dayOfWeekMap.put("среде", WEDNESDAY);
        dayOfWeekMap.put("средой", WEDNESDAY);
        dayOfWeekMap.put("среды", WEDNESDAY);
        dayOfWeekMap.put("средами", WEDNESDAY);

        //Четверг Thursday
        dayOfWeekMap.put("чт", THURSDAY);
        dayOfWeekMap.put("четверг", THURSDAY);
        dayOfWeekMap.put("четвергов", THURSDAY);
        dayOfWeekMap.put("четверга", THURSDAY);
        dayOfWeekMap.put("четвергу", THURSDAY);
        dayOfWeekMap.put("четвергом", THURSDAY);
        dayOfWeekMap.put("четверге", THURSDAY);
        dayOfWeekMap.put("четвергам", THURSDAY);

        //Пятница Friday
        dayOfWeekMap.put("пт", FRIDAY);
        dayOfWeekMap.put("пятница", FRIDAY);
        dayOfWeekMap.put("пятницей", FRIDAY);
        dayOfWeekMap.put("пятнице", FRIDAY);
        dayOfWeekMap.put("пятницы", FRIDAY);
        dayOfWeekMap.put("пятницам", FRIDAY);

        //Суббота Saturday
        dayOfWeekMap.put("сб", SATURDAY);
        dayOfWeekMap.put("субб", SATURDAY);
        dayOfWeekMap.put("суббот", SATURDAY);
        dayOfWeekMap.put("суббота", SATURDAY);
        dayOfWeekMap.put("субботе", SATURDAY);
        dayOfWeekMap.put("субботу", SATURDAY);
        dayOfWeekMap.put("субботой", SATURDAY);
        dayOfWeekMap.put("субботами", SATURDAY);
        dayOfWeekMap.put("субботы", SATURDAY);

        //Воскресение Sunday
        dayOfWeekMap.put("вс", SUNDAY);
        dayOfWeekMap.put("вскр", SUNDAY);
        dayOfWeekMap.put("воскр", SUNDAY);
        dayOfWeekMap.put("воскрес", SUNDAY);
        dayOfWeekMap.put("воскресение", SUNDAY);
        dayOfWeekMap.put("воскресенье", SUNDAY);
        dayOfWeekMap.put("воскресения", SUNDAY);
        dayOfWeekMap.put("воскресенья", SUNDAY);
        dayOfWeekMap.put("воскресению", SUNDAY);
        dayOfWeekMap.put("воскресенью", SUNDAY);
        dayOfWeekMap.put("воскресеньем", SUNDAY);
        dayOfWeekMap.put("воскресением", SUNDAY);
        dayOfWeekMap.put("воскресении", SUNDAY);
        dayOfWeekMap.put("воскресеньям", SUNDAY);
        dayOfWeekMap.put("воскресениям", SUNDAY);
    }

    public static boolean contains(String text) {
        return dayOfWeekMap.containsKey(text.toLowerCase());
    }

    public static Token getDayOfWeek(String text) {
        return dayOfWeekMap.get(text.toLowerCase());
    }
}
