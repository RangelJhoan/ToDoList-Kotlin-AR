package com.rangeljhoandev.todolist.services

import com.rangeljhoandev.todolist.models.Task
import com.rangeljhoandev.todolist.repositories.TaskRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class TaskServiceTest {

    @Mock
    private lateinit var taskRepository: TaskRepository

    @InjectMocks
    private lateinit var taskService: TaskService

    @BeforeEach
    fun onBefore() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `When all tasks are queried, returns a task list`() {
        // Given
        val taskListMocked = listOf(
            Task(1L, "Task 1", "Description 1", Date(), Date(), 1),
            Task(2L, "Task 2", "Description 2", Date(), Date(), 2)
        )
        Mockito.`when`(taskRepository.findAll()).thenReturn(taskListMocked)

        // When
        val taskList = taskService.getAllTasks()

        // Then
        assertTrue(taskList.toList().isNotEmpty())
        assertEquals(2, taskList.count())
    }

    @Test
    fun `When a task is searched by id and exists, returns it`() {
        // Given
        val taskId = 1L
        val taskSearched = Task(taskId, "Task 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskRepository.findById(taskId)).thenReturn(Optional.of(taskSearched))

        // When
        val taskFound = taskService.getTaskById(taskId)

        // Then
        assertEquals(taskFound, taskSearched)
    }

    @Test
    fun `When a task is searched by id but it doesn't exist, returns null`() {
        // Given
        val taskId = 1L
        Mockito.`when`(taskRepository.findById(taskId)).thenReturn(Optional.empty())

        // When
        val foundTask = taskService.getTaskById(taskId)

        // Then
        assertNull(foundTask)
    }

    @Test
    fun `When saving a task, returns it with a new ID`() {
        // Given
        val taskToSave = Task(null, "Task 1", "Description 1", Date(), Date(), 1)
        val taskSavedMocked = taskToSave.copy(id = 1L)
        Mockito.`when`(taskRepository.save(taskToSave)).thenReturn(taskSavedMocked)

        // When
        val taskSaved = taskService.saveTask(taskToSave)

        // Then
        assertEquals(taskSaved, taskSavedMocked)
        Mockito.verify(taskRepository, Mockito.times(1)).save(taskToSave)
    }

    @Test
    fun `When trying to edit a task but it doesn't exist, return null`() {
        // Given
        val taskToEdit = Task(1L, "Task 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskRepository.save(taskToEdit)).thenReturn(null)

        // When
        val taskEdited = taskService.saveTask(taskToEdit)

        // Then
        assertNull(taskEdited)
    }

    @Test
    fun `When deleting a task by id, returns the deleted task`() {
        // Given
        val taskId = 1L
        val taskToDelete = Task(taskId, "Title 1", "Description 1", Date(), Date(), 1)
        Mockito.`when`(taskRepository.findById(taskId)).thenReturn(Optional.of(taskToDelete))

        // When
        val taskDeleted = taskService.deleteTaskById(taskId)

        // Then
        assertEquals(taskToDelete, taskDeleted)
        Mockito.verify(taskRepository, Mockito.times(1)).findById(taskId)
        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(taskId)
    }

    @Test
    fun `When trying to delete a task by id but it doesn't exist, returns null`() {
        // Given
        val taskId = 1L
        Mockito.`when`(taskRepository.findById(taskId)).thenReturn(Optional.empty())

        // When
        val deletedTask = taskService.deleteTaskById(taskId)

        // Then
        assertNull(deletedTask)
        Mockito.verify(taskRepository, Mockito.never()).deleteById(taskId)
    }

}