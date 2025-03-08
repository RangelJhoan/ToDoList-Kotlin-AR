package com.rangeljhoandev.todolist.mappers

import com.rangeljhoandev.todolist.dtos.TaskDTO
import com.rangeljhoandev.todolist.models.Task

object TaskMapper {

    fun toDto(task: Task): TaskDTO = TaskDTO(
        task.id,
        task.title,
        task.description,
        task.creationDate,
        task.dueDate,
        task.state
    )

    fun toEntity(taskDTO: TaskDTO): Task = Task(
        taskDTO.id,
        taskDTO.title,
        taskDTO.description,
        taskDTO.creationDate,
        taskDTO.dueDate,
        taskDTO.state
    )

}