package dev.calixtolucas.eisentodo.application.useCases.task;

import java.util.List;
import java.util.Optional;

import dev.calixtolucas.eisentodo.domain.Task;
import dev.calixtolucas.eisentodo.domain.User;

public interface GetTaskByUser {
    
    public Optional<List<Task>> getTasks(User user);

}
