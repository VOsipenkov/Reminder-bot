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
    SUNDAY,
    _1, _2, _3, _4, _5, _6, _7, _8, _9, _10,
    _11, _12, _13, _14, _15, _16, _17, _18, _19, _20,
    _21, _22, _23, _24, _25, _26, _27, _28, _29, _30, _31;

    public static List<Token> getDays() {
        return List.of(MONDAY, TUESDAY, WEDNESDAY,
            THURSDAY, FRIDAY, SATURDAY, SUNDAY);
    }

    public static List<Token> getRepeateTypes() {
        return List.of(DAY, WEEK, MONTH);
    }

    public static List<Token> getDates() {
        return List.of(_1, _2, _3, _4, _5, _6, _7, _8, _9, _10,
            _11, _12, _13, _14, _15, _16, _17, _18, _19, _20,
            _21, _22, _23, _24, _25, _26, _27, _28, _29, _30, _31);
    }
}
