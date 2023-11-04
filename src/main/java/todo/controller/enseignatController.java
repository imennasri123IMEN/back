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

import todo.model.enseignant;
import todo.repositories.enseignantRepostories;


@RestController
@RequestMapping("/enseignant")
public class enseignatController {
	
	
	@Autowired
	enseignantRepostories enseignantRepostories;
	
	
	@GetMapping("")
	public List<enseignant> fetchAll(){
		
		
		return this.enseignantRepostories.findAll();
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addTodo(@RequestBody enseignant  enseignant ){
		
		return new ResponseEntity<>(this.enseignantRepostories.save(enseignant),HttpStatus.CREATED);
		
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		
		if(this.enseignantRepostories.findById(id).isPresent()) {
			this.enseignantRepostories.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody enseignant  enseignant  ){
		
		if(this.enseignantRepostories.findById(id).isPresent()) {
			
			enseignant.setId(id);
			return new ResponseEntity<>(this.enseignantRepostories.save(enseignant),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.enseignantRepostories.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.enseignantRepostories.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	
	

}
