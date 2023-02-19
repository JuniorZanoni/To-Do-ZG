package service.task

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Task {
    String name, description, category, status
    Integer priority
    private LocalDate dateCreate

    Task(String name, String description, String category, String status, Integer priority, LocalDate dateCreate) {
        this.name = name
        this.description = description
        this.category = category
        this.status = status
        this.priority = priority
        this.dateCreate = dateCreate
    }

    String getDateCreate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return this.dateCreate.format(formatter)
    }
}
