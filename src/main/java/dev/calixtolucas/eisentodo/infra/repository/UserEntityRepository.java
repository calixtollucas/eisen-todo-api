package dev.calixtolucas.eisentodo.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.calixtolucas.eisentodo.infra.entity.UserEntity;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long>{
    
}
