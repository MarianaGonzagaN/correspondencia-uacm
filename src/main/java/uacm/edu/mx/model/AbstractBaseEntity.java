package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.Data;


@MappedSuperclass
public abstract class AbstractBaseEntity{
	
	@Column(name="nombre", nullable = false)
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
