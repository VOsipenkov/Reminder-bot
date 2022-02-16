package org.bot.reminder.parser.dictionary;

import java.util.HashMap;
import java.util.Map;

import static org.bot.reminder.parser.dictionary.Token._25;

public class DateDictionary {
    private static Map<String, Token> d;

    static {
        d = new HashMap<>();
        d.put("1", Token._1);
        d.put("2", Token._2);
        d.put("3", Token._3);
        d.put("4", Token._4);
        d.put("5", Token._5);
        d.put("6", Token._6);
        d.put("7", Token._7);
        d.put("8", Token._8);
        d.put("9", Token._9);
        d.put("10", Token._10);

        d.put("11", Token._11);
        d.put("12", Token._12);
        d.put("13", Token._13);
        d.put("14", Token._14);
        d.put("15", Token._15);
        d.put("16", Token._16);
        d.put("17", Token._17);
        d.put("18", Token._18);
        d.put("19", Token._19);
        d.put("20", Token._20);

        d.put("21", Token._21);
        d.put("22", Token._22);
        d.put("23", Token._23);
        d.put("24", Token._24);
        d.put("25", _25);
        d.put("26", Token._26);
        d.put("27", Token._27);
        d.put("28", Token._28);
        d.put("29", Token._29);
        d.put("30", Token._30);
        d.put("31", Token._31);
    }

    public static boolean contains(String text) {
        return d.containsKey(text);
    }

    public static Token getToken(String key) {
        return d.get(key);
    }

    public static String getValue(Token token) {
        for (var item : d.entrySet()) {
            if (item.getValue().equals(token)) {
                return item.getKey();
            }
        }
        return null;
    }
}
