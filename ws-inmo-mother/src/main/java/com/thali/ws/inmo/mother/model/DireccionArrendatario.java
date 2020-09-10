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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DIRECCIONES_ARRENDATARIO")
@Entity
public class DireccionArrendatario implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_DIRECCCION")
	private Integer codigoDireccion;
	
	@Column(name = "NOMENCLATURA", nullable = false, length = 100)
	private String nomenclatura;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_ARRENDATARIO", foreignKey = @ForeignKey(name = "FK_DIRECCION_ARRENDATARIO"), nullable = false)
	private Arrendatario arrendatario;	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8838952035556906925L;
	

}
