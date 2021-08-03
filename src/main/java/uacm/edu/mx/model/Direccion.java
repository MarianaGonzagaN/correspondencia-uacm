package uacm.edu.mx.model;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@Table(name="direccion")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idDireccion;
	
	@NotBlank(message = "calle  es requerido")
	@Size(min= 5, max = 50)
	@Column(name = "calle",nullable = false, length = 50)
	private String calle;
	
	@NotBlank(message = "colonia es requerido")
	@Size(min= 5, max = 50)
	@Column(name = "colonia", nullable = false, length = 50)
	private String colonia;
	
	@NotBlank(message = "codigo postales es requerido")
	@Column(name = "cod_postal", nullable = false , length = 5)
	private String codPostal;
	
	@NotBlank(message = "delegaciones requerido")
	@Size(min= 5, max = 50)
	@Column(name = "delegacion", nullable = false, length = 50)
	private String delegacion;
	
	@NotBlank(message = "ciudad es requerido")
	@Size(min= 4, max = 50)
	@Column(name = "ciudad", nullable = false,  length = 50)
	private String ciudad;
	

}
