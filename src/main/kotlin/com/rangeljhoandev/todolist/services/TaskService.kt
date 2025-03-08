package com.rangeljhoandev.todolist.services

import com.rangeljhoandev.todolist.dtos.TaskDTO
import com.rangeljhoandev.todolist.mappers.TaskMapper
import com.rangeljhoandev.todolist.repositories.TaskRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TaskService(private val taskRepository: TaskRepository) {

    fun getAllTasks(): List<TaskDTO> {
        return taskRepository.findAll().map { task ->
            TaskMapper.toDto(task)
        }
    }

    fun getTaskById(id: Long): TaskDTO? {
        return taskRepository.findByIdOrNull(id)?.let { task ->
            TaskMapper.toDto(task)
        }
    }

    fun saveTask(taskDto: TaskDTO): TaskDTO? {
        val task = taskRepository.save(TaskMapper.toEntity(taskDto))
        return TaskMapper.toDto(task)
    }

    fun deleteTaskById(taskId: Long): TaskDTO? {
        val oTask = taskRepository.findById(taskId)
        if (oTask.isPresent) {
            taskRepository.deleteById(taskId)
            return TaskMapper.toDto(oTask.get())
        }

        return null
    }

}