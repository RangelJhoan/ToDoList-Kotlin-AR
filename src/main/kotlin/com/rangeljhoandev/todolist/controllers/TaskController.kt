package com.rangeljhoandev.todolist.controllers

import com.rangeljhoandev.todolist.dtos.TaskDTO
import com.rangeljhoandev.todolist.services.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
class TaskController(private val taskService: TaskService) {

    @GetMapping("/")
    fun getAllTasks(): ResponseEntity<List<TaskDTO>> {
        return ResponseEntity<List<TaskDTO>>(taskService.getAllTasks(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getTaskById(@PathVariable id: Long): ResponseEntity<TaskDTO?> {
        val response = taskService.getTaskById(id) ?: return ResponseEntity<TaskDTO?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<TaskDTO?>(response, HttpStatus.OK)
    }

    @PostMapping("/save")
    fun saveTask(@Valid @RequestBody task: TaskDTO): ResponseEntity<TaskDTO?> {
        val response = taskService.saveTask(task) ?: return ResponseEntity<TaskDTO?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<TaskDTO?>(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable(name = "id") taskId: Long): ResponseEntity<TaskDTO?> {
        val response = taskService.deleteTaskById(taskId) ?: return ResponseEntity<TaskDTO?>(HttpStatus.NO_CONTENT)
        return ResponseEntity<TaskDTO?>(response, HttpStatus.OK)
    }

}
