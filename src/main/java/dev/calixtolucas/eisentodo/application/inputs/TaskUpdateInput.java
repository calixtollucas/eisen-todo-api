package dev.calixtolucas.eisentodo.application.inputs;

import java.time.LocalDate;

public record TaskUpdateInput(
    String title, 
    LocalDate completionDate,
    Boolean isImportant,
    Boolean isUrgent
    ) {
    
}
