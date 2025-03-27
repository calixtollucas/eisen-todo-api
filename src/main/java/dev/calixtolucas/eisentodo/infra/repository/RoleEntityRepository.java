package dev.calixtolucas.eisentodo.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.calixtolucas.eisentodo.enums.RoleUser;
import dev.calixtolucas.eisentodo.infra.entity.RoleEntity;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer>{

    public Optional<RoleEntity> findByRoleName(RoleUser roleName);
    
}
