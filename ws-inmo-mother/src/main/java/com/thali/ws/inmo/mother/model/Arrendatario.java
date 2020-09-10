/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.thali.ws.inmo.mother.util.enums.TipoPersonaEnum;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thaliana
 *
 */
@Data
@NoArgsConstructor
@Table(name = "ARRENDATARIOS")
@Entity
public class Arrendatario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_ARRENDATARIO")
	private Integer codigoArrendatario;

	@Column(name = "NUMERO_DOCUMENTO", length = 15, nullable = false)
	private String numeroDocumento;

	@Column(name = "PRIMER_NOMBRE", length = 60)
	private String primerNombre;

	@Column(name = "SEGUNDO_NOMBRE", length = 60)
	private String segundoNombre;

	@Column(name = "PRIMER_APELLIDO", length = 60)
	private String primerApellido;

	@Column(name = "SEGUNDO_APELLIDO", length = 60)
	private String segundoApellido;

	@Column(name = "RAZON_SOCIAL", length = 160)
	private String razonSocial;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PERSONA")
	private TipoPersonaEnum tipoPersonaEnum;
	
	@Column(name = "TIPO_DOCUMENTO", length = 60)
	private String tipoDocumento;
	
	@Column(name = "CORREO_ELECTRONICO", length = 60)
	private String correoElectronico;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="arrendatario", cascade=CascadeType.ALL)
	private List<DireccionArrendatario> direcciones;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="arrendatario", cascade=CascadeType.ALL)
	private List<TelefonoArrendatario> telefonos;


	/**
	 * 
	 */
	private static final long serialVersionUID = 3062105321349519985L;

}
