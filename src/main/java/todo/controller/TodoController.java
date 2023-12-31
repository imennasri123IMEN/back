package todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import todo.model.admin;
import todo.repositories.TodoRepository;

@RestController
@RequestMapping("/admin")
public class TodoController {
	
	
	@Autowired
	TodoRepository todoRepository;
	
	
	@GetMapping("")
	public List<admin> fetchAll(){
		
		
		return this.todoRepository.findAll();
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addTodo(@RequestBody admin admin){
		
		return new ResponseEntity<>(this.todoRepository.save(admin),HttpStatus.CREATED);
		
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		
		if(this.todoRepository.findById(id).isPresent()) {
			this.todoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody admin admin ){
		
		if(this.todoRepository.findById(id).isPresent()) {
			
			admin.setId(id);
			return new ResponseEntity<>(this.todoRepository.save(admin),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.todoRepository.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.todoRepository.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	
	

}
