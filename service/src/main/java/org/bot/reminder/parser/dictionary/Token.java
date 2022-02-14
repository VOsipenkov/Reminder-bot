package org.bot.reminder.parser.dictionary;

import java.util.List;

public enum Token {
    EVERY,
    WEEK,
    DAY,
    MONTH,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static List<Token> getDays() {
        return List.of(MONDAY, TUESDAY, WEDNESDAY,
            THURSDAY, FRIDAY, SATURDAY, SUNDAY);
    }

    public static List<Token> getRepeateTypes() {
        return List.of(DAY, WEEK, MONTH);
    }
}
