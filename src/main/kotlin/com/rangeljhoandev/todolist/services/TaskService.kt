package com.rangeljhoandev.todolist.services

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.repositories.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class TaskService {

    @Autowired
    lateinit var taskRepository: TaskRepository

    fun getAllTasks(): MutableIterable<Task> {
        return taskRepository.findAll()
    }

    fun getTaskById(id: Long): Task? {
        return taskRepository.findByIdOrNull(id)
    }

    fun saveTask(task: Task): Task {
        return taskRepository.save(task)
    }

    fun deleteTaskById(taskId: Long): Task? {
        val oTask = taskRepository.findById(taskId)
        if (oTask.isPresent) {
            taskRepository.deleteById(taskId)
            return oTask.get()
        }

        return null
    }

}