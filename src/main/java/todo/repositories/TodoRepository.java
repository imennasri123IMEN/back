package todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import todo.model.admin;





@Repository
public interface TodoRepository extends JpaRepository<admin, Integer> {

}
