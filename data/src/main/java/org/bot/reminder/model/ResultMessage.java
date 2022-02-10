package org.bot.reminder.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ResultMessage {
    private Task task;
    private UserInfo userInfo;
}
