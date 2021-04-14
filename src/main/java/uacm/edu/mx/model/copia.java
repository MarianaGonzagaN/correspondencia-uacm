package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="")
public class copia extends AbstractBaseEntity{
	
	@Id
	@SequenceGenerator(name="",
    sequenceName="",
    allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="")
	@Column(name = "id",nullable = false)
	private Long id;
	
	public copia() {

	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
