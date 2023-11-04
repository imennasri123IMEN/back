package todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer age;
	private String nom;
	private String Ncarte;
	private String role;
	private Integer note;
	
	
	

	public etudiant() {
		super();
	}
	public etudiant(Integer id, Integer age, String nom, String ncarte, String role,Integer note) {
		super();
		this.id = id;
		this.age = age;
		this.nom = nom;
		Ncarte = ncarte;
		this.role = role;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNcarte() {
		return Ncarte;
	}
	public void setNcarte(String ncarte) {
		Ncarte = ncarte;
	}

	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	public boolean isReussi() {
	    
	    return note >= 10;}
	

}
