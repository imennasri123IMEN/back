package todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todo.model.enseignant;
@Repository
public interface enseignantRepostories extends JpaRepository<enseignant , Integer>{

}
