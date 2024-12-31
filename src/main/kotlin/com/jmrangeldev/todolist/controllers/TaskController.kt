package com.jmrangeldev.todolist.controllers

import com.jmrangeldev.todolist.models.Task
import com.jmrangeldev.todolist.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @GetMapping("/tasks")
    fun getAll(): MutableIterable<Task> {
        return taskService.getTasks()
    }

}