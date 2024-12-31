package com.jmrangeldev.todolist.models

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "tasks")
data class Task(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val title: String,
    val description: String,
    @Column(name = "creation_date")
    val creationDate: Date,
    @Column(name = "due_date")
    val dueDate: Date,
    val state: Short
)
