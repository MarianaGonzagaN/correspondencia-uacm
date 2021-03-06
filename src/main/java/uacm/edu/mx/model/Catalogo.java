package uacm.edu.mx.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo", uniqueConstraints = { @UniqueConstraint(columnNames = { "catalogo_nombre" }, name = "catalogo_nombre") })
public class Catalogo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "catalogo_nombre")
    private String nombre;

	public Catalogo() {
		super();
	}

	public Catalogo(String nombre) {
		super();
		this.nombre = nombre;
	}




}
