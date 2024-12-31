package com.jmrangeldev.todolist.repositories

import com.jmrangeldev.todolist.models.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}