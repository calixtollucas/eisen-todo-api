package dev.calixtolucas.eisentodo.application.useCases.interfaces.task;

import dev.calixtolucas.eisentodo.domain.Task;

public interface FindTaskByTitleAndUserIdUseCase {

    public Task findTask(String title, Long userId);
    
}
