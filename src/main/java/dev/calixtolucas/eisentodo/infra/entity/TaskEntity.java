package dev.calixtolucas.eisentodo.infra.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ColumnDefault;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Entity
public class TaskEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private LocalDate completionDate;

    @Column(nullable = false)
    @ColumnDefault(value = "false")
    private Boolean isImportant;

    @Column(nullable = false)
    @ColumnDefault(value = "false")
    private Boolean isUrgent;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity user;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public Boolean getIsUrgent() {
        return isUrgent;
    }

    public UserEntity getUser() {
        return user;
    }


}
