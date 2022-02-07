package org.bot.reminder;

import org.springframework.stereotype.Service;

import static org.bot.reminder.RegexpHelper.*;

@Service
public class MessageProcessorService {

    public String prepareMessage(String message) {

        if (checkStartWithSlash(message)) {
            message = replacePrefixSlash(message);
        }
        if (checkEndWithSlash(message)) {
            message = replacePostFixSlash(message);
        }
        return trimMessage(message);
    }

    public String processMessage(String message) {
        return null;
    }
}
