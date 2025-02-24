package com.rangeljhoandev.todolist.controllers

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.services.TaskService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TaskControllerTest {

    @Mock
    private lateinit var taskService: TaskService

    @InjectMocks
    private lateinit var taskController: TaskController

    @BeforeEach
    fun onBefore() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `When all tasks are queried, returns a task list`() {
        // Given
        val taskListMocked = arrayListOf(
            Task(1L, "Task 1", "Description 1", Date(), Date(), 1),
            Task(2L, "Task 2", "Description 2", Date(), Date(), 2)
        )
        Mockito.`when`(taskService.getAllTasks()).thenReturn(taskListMocked)

        // When
        val taskList = taskController.getAllTasks()

        // Then
        assertTrue(taskList.toList().isNotEmpty())
        assertEquals(2, taskList.count())
    }

    @Test
    fun `If a task is searched by id and it exists, returns 200 OK status code and the task in the body`() {
        // Given
        val taskId = 1L
        val task = Task(taskId, "Task 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskService.getTaskById(taskId)).thenReturn(task)

        // When
        val responseEntity = taskController.getTaskById(taskId)

        // Then
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertEquals(task, responseEntity.body)
    }

    @Test
    fun `If a task is searched by id but it doesn't exist, response a 204 No Content error code and a null body`() {
        // Given
        val taskId = 1L
        Mockito.`when`(taskService.getTaskById(taskId)).thenReturn(null)

        // When
        val responseEntity = taskController.getTaskById(taskId)

        // Then
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.statusCode)
        assertNull(responseEntity.body)
    }

    @Test
    fun `When creating a task, returns 200 OK status code and the task with a new ID`() {
        // Given
        val taskToCreate = Task(null, "Task 1", "Description 1", Date(), Date(), 1)
        val taskCreatedMocked = taskToCreate.copy(id = 1L)
        Mockito.`when`(taskService.saveTask(taskToCreate)).thenReturn(taskCreatedMocked)

        // When
        val responseEntity = taskController.saveTask(taskToCreate)

        // Then
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertEquals(taskCreatedMocked, responseEntity.body)
    }

    @Test
    fun `If a task to edit doesn't exist, returns a 204 No Content error code`() {
        // Given
        val taskToEdit = Task(1, "Title 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskService.saveTask(taskToEdit)).thenReturn(null)

        // When
        val responseEntity = taskController.saveTask(taskToEdit)

        // Then
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.statusCode)
        assertNull(responseEntity.body)
    }

    @Test
    fun `When deleting a task, returns a 200 OK status code and the task deleted in the body`() {
        // Given
        val taskId = 1L
        val taskToDelete = Task(taskId, "Task 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskService.deleteTaskById(taskId)).thenReturn(taskToDelete)

        // When
        val responseEntity = taskController.deleteTask(taskId)

        // Then
        assertEquals(HttpStatus.OK, responseEntity.statusCode)
        assertEquals(taskToDelete, responseEntity.body)
    }

    @Test
    fun `If a task to delete by id doesn't exist, returns a 204 No Content error code and a null body`() {
        // Given
        val taskId = 1L
        Mockito.`when`(taskService.deleteTaskById(taskId)).thenReturn(null)

        // When
        val responseEntity = taskController.deleteTask(taskId)

        // Then
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.statusCode)
        assertNull(responseEntity.body)
    }

}