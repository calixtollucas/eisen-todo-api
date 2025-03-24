package dev.calixtolucas.eisentodo.domain;

import java.time.LocalDate;

import lombok.Builder;

@Builder
public class Task {
    private Long id;
    private String title;
    private LocalDate completionDate;
    private Boolean isImportant;
    private Boolean isUrgent;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public void setIsUrgent(Boolean isUrgent) {
        this.isUrgent = isUrgent;
    }

    
}
