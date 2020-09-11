package com.thali.ws.inmo.mother.model;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@Table(name = "PAGOS_CONTRATO")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoContrato implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PAGO")
	private Integer codigoPago;
	
	@Column(name = "FECHA_HORA_REGISTRO")
	private LocalDateTime fechaHoraRegistro;
	
	@Column(name = "VALOR_PAGADO", nullable = false)
	private Long valorPagado;
	
	@Column(name = "CONCEPTO")
	private String concepto;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_CONTRATO", foreignKey = @ForeignKey(name = "FK_PAGO_CONTRATO"), nullable = false)
	private Contrato contrato;
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3460564306548372337L;

}
