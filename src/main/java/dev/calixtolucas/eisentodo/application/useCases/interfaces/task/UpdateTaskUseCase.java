package dev.calixtolucas.eisentodo.application.useCases.interfaces.task;

import dev.calixtolucas.eisentodo.application.inputs.TaskUpdateInput;

public interface UpdateTaskUseCase {
    
    public Boolean updateTask(Long id, TaskUpdateInput updatedTask);

}
