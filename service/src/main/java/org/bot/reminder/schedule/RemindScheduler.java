package org.bot.reminder.schedule;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bot.reminder.repository.TaskRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RemindScheduler {
    private final TaskRepository taskRepository;

    //8, 9 and 10 o'clock of every day
    @Scheduled(cron = "0 0 9 * * *")
    public void doRemind() {
        log.info("doRemind started");
    }
}
