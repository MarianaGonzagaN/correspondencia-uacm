package uacm.edu.mx.model;

import java.util.List;

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
	
    @Column(name = "catalogo_nombre", length = 100)
    private String nombre;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "catalogo", orphanRemoval = true)
    private List<CatalogoValores> valores;

	public Catalogo() {
		super();
	}
	
	public void addValor(CatalogoValores valor) {
		valores.add(valor);
	}

}
