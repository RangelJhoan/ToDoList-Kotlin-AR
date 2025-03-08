package com.rangeljhoandev.todolist.dtos

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import java.util.*

data class TaskDTO(
    val id: Long?,
    @field:Size(min = 2, max = 255)
    val title: String,
    @field:Size(min = 2, max = 255)
    val description: String,
    @JsonProperty("creation_date") // Specify JSON property name
    val creationDate: Date,
    @JsonProperty("due_date") // Specify JSON property name
    val dueDate: Date,
    @field:Positive
    val state: Short
) {
    @AssertTrue(message = "Due date must be after to creation date")
    fun isDueDateAfterCreationDate(): Boolean = dueDate.after(creationDate)
}
