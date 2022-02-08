package org.bot.reminder.processing;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageReader messageReader;
    private final MessageWriter messageWriter;

    public void process(Message message) {
        var data = messageReader.process(message);
        //todo запомнил
        messageWriter.responseMessage(data);
    }
}
