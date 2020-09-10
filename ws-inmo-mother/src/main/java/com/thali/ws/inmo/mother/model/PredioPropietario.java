/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.thali.ws.inmo.mother.util.enums.TipoPredioEnum;

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
@Table(name = "PREDIOS_PROPIETARIO")
@Entity
public class PredioPropietario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CODIGO_PREDIO_PROPIETARIO")
	private Integer codigoPredioPropietario;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_PREDIO", length = 15, nullable = false)
	private TipoPredioEnum tipoPredioEnum;

	@Column(name = "DIRECCION", length = 180, nullable = false)
	private String direccion;

	@Column(name = "UBICACION", length = 30)
	private String ubicacion;

	@Column(name = "AREA_CONSTRUIDA", length = 10)
	private String areaConstruida;

	@Column(name = "DESCRIPCION_ESTADO")
	private String descripcionEstado;

	@Column(name = "CANTIDAD_BAÑOS", length = 3)
	private Integer cantidadBaños;

	@Column(name = "CANTIDAD_HABITACIONES", length = 3)
	private Integer cantidadHabitaciones;

	@Column(name = "ESTRATO", length = 1)
	private Integer estrato;

	@Column(name = "CANTIDAD_PARQUEADERO", length = 2)
	private Integer cantidadParqueadero;
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_PROPIETARIO", foreignKey = @ForeignKey(name = "FK_PREDIO_PROPIETARIO"), nullable = false)
	private Propietario propietario;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3542573197911600000L;

}
