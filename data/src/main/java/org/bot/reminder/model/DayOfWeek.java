package org.bot.reminder.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "DAY_OF_WEEK")
@NoArgsConstructor
@ToString(exclude = "task")
public class DayOfWeek {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "value_data")
    private String valueData;

    @ManyToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL)
    @JoinColumn(name = "task")
    private Task task;
}
