package org.bot.reminder.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@ToString
@Table(name = "USER_INFO")
public class UserInfo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    @JoinColumn(name = "task")
    private Task task;
}
