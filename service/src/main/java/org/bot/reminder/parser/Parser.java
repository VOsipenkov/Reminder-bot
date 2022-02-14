package org.bot.reminder.parser;

import org.bot.reminder.parser.dictionary.Token;

import java.util.Set;
import java.util.stream.Collectors;

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
}
