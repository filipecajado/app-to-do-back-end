package br.com.apptodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apptodo.entity.TaskEntity;
import br.com.apptodo.interfaces.TaskService;
import br.com.apptodo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository repository;

	public TaskServiceImpl(TaskRepository repository) {
		this.repository = repository;
	}

	public TaskEntity save(TaskEntity task) {
		return repository.save(task);
	}	

	public TaskEntity update(TaskEntity task) {
		return repository.save(task);
	}

	public List<TaskEntity> getAll() {
		List<TaskEntity> tasks = (List<TaskEntity>) repository.findAll();
		return tasks;
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public void deleteAll() {
		repository.deleteAll();
	}

	public void changeChecked(Boolean checked, Long id) {
		repository.changeChecked(checked, id);
	}

}
