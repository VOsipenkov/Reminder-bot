package org.bot.reminder.repository;

import org.bot.reminder.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, String> {

}
