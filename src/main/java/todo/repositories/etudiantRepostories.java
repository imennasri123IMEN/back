package todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todo.model.etudiant;
@Repository
public interface etudiantRepostories extends JpaRepository<etudiant, Integer>{
}
