package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="catalogo_serie")
public class Serie extends AbstractBaseEntity{
	
	@Id
	@SequenceGenerator(name = "catalogo_serie_id_seq", sequenceName = "catalogo_serie_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogo_serie_id_seq")
	@Column(name = "id", nullable = false)
	private int id;
	

	public Serie() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
