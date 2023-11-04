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

import todo.model.etudiant;
import todo.repositories.etudiantRepostories;

@RestController
@RequestMapping("/etudiant")
public class etudiantController {
	
	
	@Autowired
	etudiantRepostories etudiantRepostories;
	
	
	@GetMapping("")
	public List<etudiant> fetchAll(){
		
		
		return this.etudiantRepostories.findAll();
	}
	
	
	@PostMapping("")
	public ResponseEntity<?> addTodo(@RequestBody etudiant  etudiant ){
		
		return new ResponseEntity<>(this.etudiantRepostories.save(etudiant),HttpStatus.CREATED);
		
	}
	
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
		
		if(this.etudiantRepostories.findById(id).isPresent()) {
			this.etudiantRepostories.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodo(@PathVariable Integer id, @RequestBody etudiant  etudiant ){
		
		if(this.etudiantRepostories.findById(id).isPresent()) {
			
			etudiant.setId(id);
			return new ResponseEntity<>(this.etudiantRepostories.save(etudiant),HttpStatus.OK);
		}
		else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/taux-reussite")
	public ResponseEntity<Double> calculateTauxReussite() {
	    List<etudiant> etudiants = etudiantRepostories.findAll();
	    
	    if (etudiants.isEmpty()) {
	        return new ResponseEntity<>(0.0, HttpStatus.OK);
	    } else {
	        long reussis = etudiants.stream().filter(etudiant -> etudiant.isReussi()).count();
	        double tauxReussite = (double) reussis / etudiants.size() * 100;
	        
	        return new ResponseEntity<>(tauxReussite, HttpStatus.OK);
	    }
	}
	
	


	@GetMapping("/calculate")
    public ResponseEntity<Double> calculateTauxAbsence() {
        List<etudiant> etudiants = etudiantRepostories.findAll();
        
        if (etudiants.isEmpty()) {
            return new ResponseEntity<>(0.0, HttpStatus.OK);
        } else {
            long absents = etudiants.stream().filter(etudiant -> "absent".equalsIgnoreCase(etudiant.getRole())).count();
            double tauxAbsence = (double) absents / etudiants.size() * 100;
            
            return new ResponseEntity<>(tauxAbsence, HttpStatus.OK);
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id){
		
		if(this.etudiantRepostories.findById(id).isPresent()) {
			
			return new ResponseEntity<>(this.etudiantRepostories.findById(id),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}
	
	
    }
	


