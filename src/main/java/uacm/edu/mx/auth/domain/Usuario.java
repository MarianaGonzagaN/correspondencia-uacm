package uacm.edu.mx.auth.domain;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;


@Entity
@Table(name = "user_extend")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 100)
    private String nombreCompleto;
    
    @NotNull
    @Pattern(regexp = "([0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9][0-9])")
    @Column(name = "matricula", nullable = false, unique = true)
    private String matricula;
    
	@NotBlank
	@Size(max = 50)
    private String carrera;
	
	@NotBlank
	@Size(max = 50)
    private String plantel;
	
	@NotBlank
	@Size(max = 50)
    private String turno;
	
    private String urlfoto;
    
    @NotBlank
	@Size(max = 50)
    private String genero;
    
    @NotBlank
	@Size(max = 50)
    private Date fechaNacimiento;
    
    }
