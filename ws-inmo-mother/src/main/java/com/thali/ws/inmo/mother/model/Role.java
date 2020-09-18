/**
 * 
 */
package com.thali.ws.inmo.mother.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Thaliana
 *
 */
@Data
@Entity
@Table(name = "ROLES")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoRole;
	
	@Column(unique = true, length = 20)
	private String nombreRole;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1528797232759494746L;

}
