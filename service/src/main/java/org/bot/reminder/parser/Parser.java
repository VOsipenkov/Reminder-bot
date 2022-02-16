package org.bot.reminder.parser;

import org.bot.reminder.parser.dictionary.DateDictionary;
import org.bot.reminder.parser.dictionary.Token;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import static org.bot.reminder.parser.dictionary.Token.DAY;
import static org.bot.reminder.parser.dictionary.Token.EVERY;

public class Parser {

    public static Set<Token> getDaysOfWeek(Set<Token> tokens) {
        return tokens.stream()
            .filter(token -> Token.getDays().contains(token))
            .collect(Collectors.toSet());
    }

    public static Boolean isRepeatable(Set<Token> tokens) {
        return tokens.contains(EVERY);
    }

    public static Token getRepeateType(Set<Token> tokens) {
        return tokens.stream()
            .filter(token -> Token.getRepeateTypes().contains(token))
            .findFirst().orElse(null);
    }

    public static String getRepeateDate(Set<Token> tokens) {
        if (!tokens.contains(EVERY)) {
            return null;
        } else if (tokens.contains(DAY)) {
            return null;
        }

        var token = tokens.stream()
            .filter(t -> Token.getDates().contains(t))
            .findFirst().orElse(null);
        if (token == null) {
            String today = Integer.toString(LocalDate.now().getDayOfMonth());
            token = DateDictionary.getToken(today);
        }

        return DateDictionary.getValue(token);
    }
}
