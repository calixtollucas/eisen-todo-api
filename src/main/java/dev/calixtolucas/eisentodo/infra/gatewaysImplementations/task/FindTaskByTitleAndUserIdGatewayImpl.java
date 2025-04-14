package dev.calixtolucas.eisentodo.infra.gatewaysImplementations.task;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.calixtolucas.eisentodo.adapters.gateways.task.FindTaskByTitleAndUserIdGateway;
import dev.calixtolucas.eisentodo.domain.Task;
import dev.calixtolucas.eisentodo.infra.entity.TaskEntity;
import dev.calixtolucas.eisentodo.infra.mappers.UserMapper;
import dev.calixtolucas.eisentodo.infra.repository.TaskEntityRepository;

@Service
public class FindTaskByTitleAndUserIdGatewayImpl implements FindTaskByTitleAndUserIdGateway{
    
    TaskEntityRepository taskEntityRepository;

    @Override
    public Optional<Task> find(String title, Long userId) {
        
        //busca a task no banco
        Optional<TaskEntity> taskFoundOptional = taskEntityRepository.findByTitleAndUserId(title, userId);
        
        if(taskFoundOptional.isEmpty()){
            return Optional.of(null);
        }
        //mapeia de entidade para classe de domínio
            TaskEntity taskFound = taskFoundOptional.get();
            return Optional.of(
                Task.builder()
                    .id(taskFound.getId())
                    .title(taskFound.getTitle())
                    .completionDate(taskFound.getCompletionDate())
                    .isImportant(taskFound.getIsImportant())
                    .isUrgent(taskFound.getIsUrgent())
                    .user(UserMapper.toUser(taskFound.getUser()))
                    .build()
            );

    }



}
