package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="catalogo_turnado_a")
public class TurnadoA extends AbstractBaseEntity{
	
	@Id
	@SequenceGenerator(name="catalogo_turnado_a_seq",sequenceName="catalogo_turnado_a_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catalogo_turnado_a_seq")
	@Column(name = "id",nullable = false)
	private Long id;
	
	public TurnadoA() {

	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
