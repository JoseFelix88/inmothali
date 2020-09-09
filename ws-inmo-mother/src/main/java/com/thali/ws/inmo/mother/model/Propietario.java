/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;
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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Thaliana
 *
 */
@Table(name = "PROPIETARIOS")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Propietario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PROPIETARIO")
	private Integer codigoProdietario;
	
	@Column(name = "NUMERO_IDENTIFICACION", length = 20, nullable = false)
	private String numeroIdentificacion;
	
	@Column(name = "NOMBRES", length = 40, nullable = false)
	private String nombres;
	
	@Column(name = "APELLIDOS", length = 40)
	private String apellidos;
	
	@Column(name = "CORREO", length = 80)
	private String correo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="propietario", cascade=CascadeType.ALL)
	private List<PropietarioDireccion> direcciones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="propietario", cascade=CascadeType.ALL)
	private List<PropietarioTelefono> telefonos;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7269377185677569265L;
	
	

}
