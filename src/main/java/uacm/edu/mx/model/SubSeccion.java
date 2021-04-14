package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="catalogo_subseccion")
public class SubSeccion extends AbstractBaseEntity{
	
	@Id
	@SequenceGenerator(name = "catalogo_subseccion_id_seq", sequenceName = "catalogo_subseccion_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_subseccion_id_seq")
	@Column(name = "id", nullable = false)
	private int id;

	public SubSeccion() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
