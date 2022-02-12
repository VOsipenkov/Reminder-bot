package org.bot.reminder.repository;

import org.bot.reminder.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {
    List<Task> findByDayOfWeekAndIsRepeatableFalse(String dayOfWeek);

    List<Task> findByIsRepeatableAndRepeatTypeIsNotNullAndRepeatTypeIn(List<String> repeateType);
}
