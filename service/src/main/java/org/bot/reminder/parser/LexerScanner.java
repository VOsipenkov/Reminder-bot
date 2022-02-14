package org.bot.reminder.parser;

import lombok.RequiredArgsConstructor;
import org.bot.reminder.parser.dictionary.DayOfWeekDictionary;
import org.bot.reminder.parser.dictionary.RepeatableDictionary;
import org.bot.reminder.parser.dictionary.RepeateTypeDictionary;
import org.bot.reminder.parser.dictionary.Token;
import org.bot.reminder.util.TextPrepareService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LexerScanner {
    private final TextPrepareService textPrepareService;

    public Set<Token> textScan(String text) {
        Set<Token> tokens = new HashSet<>();
        text = textPrepareService.prepareText(text);
        var words = Arrays.stream(text.split(" "))
            .map(w -> w.replace(".", "").replace(",", ""))
            .collect(Collectors.toList());

        words.stream()
            .filter(RepeatableDictionary::contains)
            .collect(Collectors.toSet())
            .forEach(w -> tokens.add(Token.EVERY));

        tokens.addAll(words.stream()
            .map(DayOfWeekDictionary::getDayOfWeek)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet()));

        words.stream()
            .map(RepeateTypeDictionary::getScope)
            .filter(Objects::nonNull)
            .collect(Collectors.toSet())
            .stream().findFirst().ifPresent(tokens::add);

        return tokens;
    }
}
