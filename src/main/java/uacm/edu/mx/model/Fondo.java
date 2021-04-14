package uacm.edu.mx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="catalogo_fondo")
public class Fondo {
	
	@Id
	@SequenceGenerator(name="catalogo_fondo_id_seq",
    sequenceName="catalogo_fondo_id_seq",
    allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="catalogo_fondo_id_seq")
	@Column(name="id")
	private int id;
	@Column(name="nombre")
	private String nombre;
	@OneToOne
	@JoinColumn(name="id_direccion")
	private Direccion idDireccion;
	@Column(name="telefono")
	private String telefono;
	
	public Fondo() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getIdDireccion() {
		return idDireccion;
	}
	public void setIdDireccion(Direccion idDireccion) {
		this.idDireccion = idDireccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
