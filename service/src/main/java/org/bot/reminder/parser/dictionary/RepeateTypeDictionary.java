package org.bot.reminder.parser.dictionary;

import java.util.HashMap;
import java.util.Map;

import static org.bot.reminder.parser.dictionary.Token.*;

public class RepeateTypeDictionary {
    private static Map<String, Token> map = new HashMap<>();

    static {
        map.put("день", DAY);
        map.put("дня", DAY);
        map.put("дню", DAY);
        map.put("днем", DAY);
        map.put("днём", DAY);
        map.put("дне", DAY);
        map.put("дней", DAY);
        map.put("дни", DAY);

        map.put("неделя", WEEK);
        map.put("неделю", WEEK);
        map.put("неделе", WEEK);
        map.put("неделей", WEEK);
        map.put("недель", WEEK);
        map.put("неделью", WEEK);
        map.put("неделями", WEEK);

        map.put("месяц", MONTH);
        map.put("месяца", MONTH);
        map.put("месяцу", MONTH);
        map.put("месяцем", MONTH);
        map.put("месяце", MONTH);
        map.put("месяцев", MONTH);
        map.put("месяцами", MONTH);
        map.put("месяцам", MONTH);
    }

    public static boolean contains(String text) {
        return map.containsKey(text.toLowerCase());
    }

    public static Token getScope(String text) {
        return map.get(text.toLowerCase());
    }
}
