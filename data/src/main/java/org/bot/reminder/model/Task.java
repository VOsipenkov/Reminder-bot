package org.bot.reminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Task {
    private LocalDate date;
    private String action;
    private Repeat repeatCycle;
    private DayOfWeek dayOfWeek;
}
