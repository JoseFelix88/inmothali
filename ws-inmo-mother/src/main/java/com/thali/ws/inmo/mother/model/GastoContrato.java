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

@Table(name = "GASTOS_CONTRATO")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GastoContrato implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_GASTO")
	private Integer codigoGasto;
	
	@Column(name = "FECHA_EMISION")
	private LocalDate fechaEmision;
	
	@Column(name = "VALOR_GASTO")
	private Long valorGasto;
	
	@Column(name = "CONCEPTO")
	private String concepto;
	
	@Column(name = "SOPORTE")
	private String soporte;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_CONTRATO", foreignKey = @ForeignKey(name = "FK_GASTO_CONTRATO"), nullable = false)
	private Contrato contrato;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5419776683456692275L;

	
}
