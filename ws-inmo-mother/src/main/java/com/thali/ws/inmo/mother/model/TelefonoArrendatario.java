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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Thaliana
 *
 */
@Table(name = "TELEFONOS_ARRENDATARIO")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelefonoArrendatario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6341735607711802157L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_TELEFONO")
	private Integer codigoTefono;

	@Column(name = "NUMERO_TELEFONO", length = 15)
	private Integer numeroTefono;

	@Column(name = "NOTA", length = 15)
	private String nota;

	@ManyToOne
	@JoinColumn(name = "CODIGO_ARRENDATARIO", foreignKey = @ForeignKey(name = "FK_TELEFONO_ARRENDATARIO"), nullable = false)
	private Arrendatario arrendatario;
}
