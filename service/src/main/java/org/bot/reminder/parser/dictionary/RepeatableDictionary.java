package org.bot.reminder.parser.dictionary;

import java.util.ArrayList;
import java.util.List;

public class RepeatableDictionary {
    private static final List<String> list = new ArrayList<>();

    static {
        list.add("Кажд");
        list.add("кажд");
        list.add("Каждый");
        list.add("каждый");
        list.add("Каждую");
        list.add("каждую");
        list.add("Раз");
        list.add("раз");
    }

    public static boolean contains(String word) {
        return list.contains(word);
    }
}
