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

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thaliana
 *
 */
@Table(name = "PROPIETARIOS")
@Entity
@Data
@NoArgsConstructor
public class Propietario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PROPIETARIO")
	private Integer codigoProdietario;
	
	@Column(name = "NUMERO_IDENTIFICACION", length = 20, nullable = false)
	private String numeroIdentificacion;
	
	@Column(name = "NOMBRES", length = 60, nullable = false)
	private String nombres;
	
	@Column(name = "APELLIDOS", length = 60)
	private String apellidos;
	
	@Column(name = "CORREO", length = 80)
	private String correo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="propietario", cascade=CascadeType.ALL)
	private List<DireccionPropietario> direcciones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="propietario", cascade=CascadeType.ALL)
	private List<TelefonoPropietario> telefonos;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "propietario", cascade = CascadeType.ALL)
	private List<PredioPropietario> predios;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7269377185677569265L;
	
	

}
