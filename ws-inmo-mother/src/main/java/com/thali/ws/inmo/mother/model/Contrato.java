/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;
import java.time.LocalDate;

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
@Table(name = "CONTRATOS")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_CONTRATO")
	private Integer codigoContrato;

	@Column(name = "FECHA_INICIO", nullable = false)
	private LocalDate fechaInicio;

	@Column(name = "FECHA_FINAL", nullable = false)
	private LocalDate fechaFINAL;

	@Column(name = "PAGO_MENSUAL", nullable = false)
	private Long pagoMensual;

	@Column(name = "DESCRIPCION_CONDICIONES", nullable = true)
	private String descripcionCondicion;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PROPIETARIO", foreignKey = @ForeignKey(name = "FK_CONTRATO_PROPIETARIO"), nullable = false)
	private Propietario propietario;

	@ManyToOne
	@JoinColumn(name = "CODIGO_ARRENDATARIO", foreignKey = @ForeignKey(name = "FK_CONTRATO_ARRENDATARIO"), nullable = false)
	private Arrendatario arrendatario;

	@ManyToOne
	@JoinColumn(name = "CODIGO_PREDIO", foreignKey = @ForeignKey(name = "FK_CONTRATO_PREDIO"), nullable = false)
	private PredioPropietario predioPropietario;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4867746478446602491L;

}
