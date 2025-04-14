package dev.calixtolucas.eisentodo.adapters.gateways.task;

import java.util.Optional;

import dev.calixtolucas.eisentodo.domain.Task;

public interface FindTaskByTitleAndUserIdGateway {
    
    public Optional<Task> find(String title, Long userId);
}
