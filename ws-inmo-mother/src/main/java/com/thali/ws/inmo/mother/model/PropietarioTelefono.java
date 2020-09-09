/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Thaliana
 *
 */
@Table(name = "PROPIETARIO_TELEFONOS")
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PropietarioTelefono implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_TELEFONO")
	private Integer codigoTefono;

	@Column(name = "NUMERO_TELEFONO", length = 15)
	private Integer numeroTefono;

	@Column(name = "NOTA", length = 15)
	private String NOTA;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PROPIETARIO", foreignKey = @ForeignKey(name = "FK_PROPIETARIO_TELEFONO"), nullable = false)
	private Propietario propietario;

	/**
	 * 
	 */
	private static final long serialVersionUID = -7396538449698218780L;

}
