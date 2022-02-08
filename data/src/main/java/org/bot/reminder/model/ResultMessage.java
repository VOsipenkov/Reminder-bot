package org.bot.reminder.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultMessage {
    private Task task;
    private UserInfo userInfo;
}
