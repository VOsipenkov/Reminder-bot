package org.bot.reminder.util;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Data
public class TextPrepareService {
    public String prepareText(String message) {
        if (checkStartWithSlash(message)) {
            message = replacePrefixSlash(message);
        }
        if (checkEndWithSlash(message)) {
            message = replacePostFixSlash(message);
        }
        return message.trim();
    }

    private boolean checkStartWithSlash(String message) {
        return !StringUtils.isEmpty(message) &&
            message.startsWith("^/+.*");
    }

    private boolean checkEndWithSlash(String message) {
        return !StringUtils.isEmpty(message) &&
            message.endsWith(".*/+$");
    }

    private String replacePrefixSlash(String message) {
        var startIdx = message.indexOf("^/+");
        return message.substring(startIdx);
    }

    private String replacePostFixSlash(String message) {
        var endIdx = message.indexOf(".*/+$");
        return message.substring(0, endIdx);
    }
}
