package org.bot.reminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@ToString(exclude = "userInfo")
@Table(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "day_of_year")
    private LocalDate dayOfYear;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "repeate_type")
    private String repeatType;

    @Column(name = "isRepeatable")
    private String isRepeatable;

    @Column(name = "action")
    private String action;

    @Column(name = "chat_id")
    private Long chatId;

    @OneToOne(fetch = FetchType.EAGER,
    mappedBy = "task")
    private UserInfo userInfo;
}
