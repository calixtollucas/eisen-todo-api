package dev.calixtolucas.eisentodo.application.useCases.task;

import dev.calixtolucas.eisentodo.domain.Task;

public interface CreateTaskUseCase {
    
    public Boolean createTask(Task task);

}
