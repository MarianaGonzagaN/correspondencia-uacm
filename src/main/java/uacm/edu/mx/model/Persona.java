package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="catalogo_persona")
public class Persona extends AbstractBaseEntity{
	
	@Id
	@SequenceGenerator(name="catalogo_persona_id_persona_seq",sequenceName="catalogo_persona_id_persona_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catalogo_persona_id_persona_seq")
	@Column(name = "id",nullable = false)
	private int id;

	
	public Persona() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	
	
}