package dev.calixtolucas.eisentodo.infra.mappers;

import dev.calixtolucas.eisentodo.domain.Task;
import dev.calixtolucas.eisentodo.infra.entity.TaskEntity;
import dev.calixtolucas.eisentodo.infra.entity.UserEntity;

public class TaskMapper {

    public static TaskEntity toEntity(Task task, UserEntity user){

        return new TaskEntity(
            task.getId(),
            task.getTitle(),
            task.getCompletionDate(),
            task.getIsImportant(),
            task.getIsUrgent(),
            user
        );

    }
    
}
