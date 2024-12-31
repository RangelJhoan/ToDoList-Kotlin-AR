package com.jmrangeldev.todolist.services

import com.jmrangeldev.todolist.models.Task
import com.jmrangeldev.todolist.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService {

    @Autowired
    lateinit var taskRepository: TaskRepository

    fun getTasks(): MutableIterable<Task> {
        return taskRepository.findAll()
    }


}