package com.rangeljhoandev.todolist.controllers

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.services.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
class TaskController(private val taskService: TaskService) {

    @GetMapping("/")
    fun getAllTasks(): MutableIterable<Task> {
        return taskService.getAllTasks()
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<Task?> {
        val response = taskService.getTaskById(id) ?: return ResponseEntity<Task?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<Task?>(response, HttpStatus.OK)
    }

    @PostMapping("/save")
    fun saveTask(@RequestBody task: Task): ResponseEntity<Task?> {
        val response = taskService.saveTask(task) ?: return ResponseEntity<Task?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<Task?>(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable(name = "id") taskId: Long): ResponseEntity<Task?> {
        val response = taskService.deleteTaskById(taskId) ?: return ResponseEntity<Task?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<Task?>(response, HttpStatus.OK)
    }

}