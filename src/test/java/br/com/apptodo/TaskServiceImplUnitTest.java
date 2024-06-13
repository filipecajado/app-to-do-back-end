package br.com.apptodo;

import static org.assertj.core.api.Assertions.assertThat;
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

import br.com.apptodo.entity.TaskEntity;
import br.com.apptodo.repository.TaskRepository;
import br.com.apptodo.service.TaskServiceImpl;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplUnitTest {

    @InjectMocks
    private TaskServiceImpl service;

    @Mock
    private TaskRepository repository;

    private List<TaskEntity> mockTaskList;

    @BeforeEach
    void setUp() {
        mockTaskList = new ArrayList<>();
        mockTaskList.add(new TaskEntity(1L, "Task 1", false));
        mockTaskList.add(new TaskEntity(2L, "Task 2", true));
        mockTaskList.add(new TaskEntity(3L, "Task 3", false));
    }

    @Test
    void saveTask() {
        TaskEntity newTask = new TaskEntity(null, "New Task", false);
        TaskEntity savedTask = new TaskEntity(1L, "New Task", false);
        when(repository.save(newTask)).thenReturn(savedTask);

        TaskEntity response = service.save(newTask);

        assertThat(savedTask).isEqualTo(response);
        verify(repository, times(1)).save(newTask);
    }

    @Test
    void updateTask() {
        TaskEntity existingTask = new TaskEntity(1L, "Updated Task", true);
        when(repository.save(existingTask)).thenReturn(existingTask);

        TaskEntity response = service.update(existingTask);

        assertThat(response).isEqualTo(existingTask);
        verify(repository, times(1)).save(existingTask);
    }

    @Test
    void getAllTasks() {
        when(repository.findAll()).thenReturn(mockTaskList);

        List<TaskEntity> response = service.getAll();

        assertThat(response).isEqualTo(mockTaskList);
        verify(repository, times(1)).findAll();
    }

    @Test
    void deleteTask() {
        Long taskId = 1L;

        service.delete(taskId);

        verify(repository, times(1)).deleteById(taskId);
    }

    @Test
    void deleteAllTasks() {
        service.deleteAll();

        verify(repository, times(1)).deleteAll();
    }

    @Test
    void changeChecked() {
        Boolean checked = true;
        Long taskId = 1L;

        service.changeChecked(checked, taskId);

        verify(repository, times(1)).changeChecked(checked, taskId);
    }
}