package br.com.apptodo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.apptodo.controller.TaskController;
import br.com.apptodo.entity.TaskEntity;
import br.com.apptodo.interfaces.TaskService;

@ExtendWith(MockitoExtension.class)
class TaskControllerUnitTest {

	@InjectMocks
	private TaskController controller;

	@Mock
	private TaskService service;

	private List<TaskEntity> mockTaskList;

	@BeforeEach
	void setUp() {
		mockTaskList = new ArrayList<>();
		mockTaskList.add(new TaskEntity(1L, "Task 1", false));
		mockTaskList.add(new TaskEntity(2L, "Task 2", true));
		mockTaskList.add(new TaskEntity(3L, "Task 3", false));
	}

	@Test
	void getAllWithSuccess() {
	      
	    when(service.getAll()).thenReturn(mockTaskList);
	   
	    ResponseEntity<List<TaskEntity>> response = controller.getAll();
		    
	    assertEquals(HttpStatus.OK, response.getStatusCode());
	    assertEquals(mockTaskList, response.getBody());
		verify(service, times(1)).getAll();
	}

	@Test
	void saveWithSuccess() {
		TaskEntity newTask = new TaskEntity(null, "New Task", false);
		TaskEntity savedTask = new TaskEntity(1L, "New Task", false);
		when(service.save(newTask)).thenReturn(savedTask);

		ResponseEntity<TaskEntity> response = controller.save(newTask);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(newTask.getDescription(), response.getBody().getDescription());
		assertEquals(newTask.getChecked(), response.getBody().getChecked());
		verify(service, times(1)).save(newTask);
	}

	@Test
	void updateWithSuccess() {
		TaskEntity existingTask = new TaskEntity(1L, "Updated Task", true);

		when(service.update(existingTask)).thenReturn(existingTask);

		ResponseEntity<TaskEntity> response = controller.update(existingTask);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(existingTask, response.getBody());
		verify(service, times(1)).update(existingTask);
	}

	@Test
	void deleteWithSuccess() {
		Long taskId = 1L;

		ResponseEntity<HttpStatus> response = controller.delete(taskId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(service, times(1)).delete(taskId);
	}

	@Test
	void deleteAllWithSuccess() {
		ResponseEntity<HttpStatus> response = controller.deleteAll();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(service, times(1)).deleteAll();
	}

	@Test
	void changeCheckedWithSuccess() {
		Boolean checked = true;
		Long taskId = 1L;

		ResponseEntity<HttpStatus> response = controller.changeChecked(checked, taskId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		verify(service, times(1)).changeChecked(checked, taskId);
	}

}
