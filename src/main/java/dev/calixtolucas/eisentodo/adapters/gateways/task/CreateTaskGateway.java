package dev.calixtolucas.eisentodo.adapters.gateways.task;

import dev.calixtolucas.eisentodo.domain.Task;

public interface CreateTaskGateway {
    
    public Boolean createTask(Task task);
}
