package dev.calixtolucas.eisentodo.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.calixtolucas.eisentodo.infra.entity.TaskEntity;

@Repository
public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long>{

    public Optional<TaskEntity> findByTitleAndUserId(String title, Long userId);
    
}
