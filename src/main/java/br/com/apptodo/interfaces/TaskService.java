package br.com.apptodo.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.apptodo.entity.TaskEntity;

@Service
public interface TaskService {
	
	TaskEntity save(TaskEntity task);

	TaskEntity update(TaskEntity task);

	List<TaskEntity> getAll();

	void delete(Long id);
	
	void deleteAll();
	
	void changeChecked(Boolean checked, Long id);
}
