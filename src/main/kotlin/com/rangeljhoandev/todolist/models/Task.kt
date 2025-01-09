package com.rangeljhoandev.todolist.models

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String,
    @Column(name = "creation_date")
    @JsonProperty("creation_date")
    val creationDate: Date,
    @Column(name = "due_date")
    @JsonProperty("due_date")
    val dueDate: Date,
    val state: Short
)
