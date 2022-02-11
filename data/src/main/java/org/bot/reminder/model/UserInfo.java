package org.bot.reminder.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "USER_INFO")
public class UserInfo {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "userInfo",
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true)
    private List<Task> task;
}
