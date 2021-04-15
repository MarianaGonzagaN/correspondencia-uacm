package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo_valores", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "catalogo_id", "valor_nombre" }, name = "valor_nombre_duplicado") })
public class CatalogoValores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor_nombre", length = 100)
	private String nombre;

	@Column(name = "descripcion")
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "catalogo_id", nullable = false)
	private Catalogo catalogo;

	public CatalogoValores() {
		super();
	}

}
