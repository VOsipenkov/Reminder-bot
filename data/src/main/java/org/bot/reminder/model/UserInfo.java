package org.bot.reminder.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserInfo {
    private String userName;
    private String firstName;
    private String lastName;
}
