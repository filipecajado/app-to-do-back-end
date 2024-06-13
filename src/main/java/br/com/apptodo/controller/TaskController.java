package br.com.apptodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.apptodo.entity.TaskEntity;
import br.com.apptodo.interfaces.TaskService;
import jakarta.annotation.Nonnull;

@RestController
@RequestMapping(value = "/tasks")
@CrossOrigin("*")
public class TaskController {

	@Autowired
	private TaskService service;

	@GetMapping()
	public ResponseEntity<List<TaskEntity>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@PostMapping()
	public ResponseEntity<TaskEntity> save(@RequestBody TaskEntity task) {	
		return ResponseEntity.ok(service.save(task));
	}
	
	@PutMapping()
	public ResponseEntity<TaskEntity> update(@RequestBody TaskEntity task) {
		
		return ResponseEntity.ok(service.update(task));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable @Nonnull Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping()
	public ResponseEntity<HttpStatus> deleteAll() {
		service.deleteAll();
		return ResponseEntity.ok().build();
	}

	@PutMapping("/checked")
	public ResponseEntity<HttpStatus> changeChecked(@RequestParam  Boolean checked, @RequestParam  Long id) {
		service.changeChecked(checked, id);
		return ResponseEntity.ok().build();
	}

}
