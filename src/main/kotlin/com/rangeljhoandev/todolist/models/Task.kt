package com.rangeljhoandev.todolist.models

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
    @Column(name = "creation_date") // Specify database property name
    val creationDate: Date,
    @Column(name = "due_date") // Specify database property name
    val dueDate: Date,
    val state: Short
)
