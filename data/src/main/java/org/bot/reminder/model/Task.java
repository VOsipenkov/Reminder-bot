package org.bot.reminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
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

    @OneToMany(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        mappedBy = "task")
    @Column(name = "day_of_week")
    private List<DayOfWeek> dayOfWeek;

    @Column(name = "repeate_type")
    private String repeatType;

    @Column(name = "isRepeatable")
    private String isRepeatable;

    @Column(name = "repeate_date")
    private String repeateDate;

    @Column(name = "action")
    private String action;

    @Column(name = "chat_id")
    private Long chatId;

    @OneToOne(fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        mappedBy = "task")
    private UserInfo userInfo;
}
