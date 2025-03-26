package dev.calixtolucas.eisentodo.application.useCases.interfaces.task;

import dev.calixtolucas.eisentodo.domain.Task;

public interface CreateTaskUseCase {
    
    public Boolean createTask(Task task);

}
