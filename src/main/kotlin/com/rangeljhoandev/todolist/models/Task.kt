package com.rangeljhoandev.todolist.models

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import jakarta.validation.constraints.AssertTrue
import jakarta.validation.constraints.Positive
import jakarta.validation.constraints.Size
import java.util.Date

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @field:Size(min = 2, max = 255)
    val title: String,
    @field:Size(min = 2, max = 255)
    val description: String,
    @Column(name = "creation_date")
    @JsonProperty("creation_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    val creationDate: Date,
    @Column(name = "due_date")
    @JsonProperty("due_date")
    val dueDate: Date,
    @Positive
    val state: Short
) {
    @AssertTrue(message = "Due date must be after to creation date")
    fun isDueDateAfterCreationDate(): Boolean = dueDate.after(creationDate)
}
