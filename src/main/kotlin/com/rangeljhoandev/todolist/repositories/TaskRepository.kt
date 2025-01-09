package com.rangeljhoandev.todolist.repositories

import com.rangeljhoandev.todolist.models.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}