package uacm.edu.mx.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Table(name="fondo",uniqueConstraints={@UniqueConstraint(columnNames={"nombre"})})
public class Fondo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotBlank(message = "nombre es requerido")
	@Size(max = 100)
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;

	@NotBlank(message = "telefono es requerido")
	@Column(name="telefono", nullable = false,  length = 10)
	@Size(min=10 , max=10)
	private String  telefono;
	
	@NotBlank(message = "fecha de creacion es requerido")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	@Column(name="fecha_creacion", nullable = false)
	private Date fechaCreacion; 
		
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_direccion", nullable = false)
	private Direccion direccion;

	public Fondo() {
		super();
	}
	
}
