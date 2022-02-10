package org.bot.reminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue
    private String id;

    @Column(name = "day_of_year")
    private LocalDate dayOfYear;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "repeate_type")
    private String repeatType;

    @Column(name = "isRepeatable")
    private Boolean isRepeatable;

    @Column(name = "action")
    private String action;

    @JoinColumn(name = "user_info_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private UserInfo userInfo;
}
