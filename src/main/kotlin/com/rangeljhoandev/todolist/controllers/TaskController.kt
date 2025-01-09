package com.rangeljhoandev.todolist.controllers

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.services.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
class TaskController {

    @Autowired
    lateinit var taskService: TaskService

    @GetMapping("/all")
    fun getAllTasks(): MutableIterable<Task> {
        return taskService.getAllTasks()
    }

    @PostMapping("/save")
    fun saveTask(@RequestBody task: Task): Task {
        println(task)
        return taskService.saveTask(task)
    }

    @GetMapping("/delete/{id}")
    fun deleteTask(@PathVariable(name = "id") taskId: Long): ResponseEntity<Task> {
        val response = taskService.deleteTaskById(taskId)
        if (response != null) {
            return ResponseEntity<Task>(response, HttpStatus.OK)
        }

        return ResponseEntity<Task>(HttpStatus.NO_CONTENT)
    }

}