package dev.calixtolucas.eisentodo.infra.entity;

import dev.calixtolucas.eisentodo.enums.RoleUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer id;

    @Column(name = "role_name")
    @Enumerated(value = EnumType.STRING)
    private RoleUser roleName;

    public Integer getId() {
        return id;
    }

    public RoleUser getRoleName() {
        return roleName;
    }

    

}
