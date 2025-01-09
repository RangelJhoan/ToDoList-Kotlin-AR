package com.rangeljhoandev.todolist.services

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService {

    @Autowired
    lateinit var taskRepository: TaskRepository

    fun getAllTasks(): MutableIterable<Task> {
        return taskRepository.findAll()
    }

    fun saveTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun deleteTaskById(id: Long): Task? {
        val oTask = taskRepository.findById(id)
        if (oTask.isPresent) {
            taskRepository.deleteById(id)
            return oTask.get()
        }

        return null
    }

}