/**
 * 
 */
package com.thali.ws.inmo.mother.util.enums;

import lombok.AllArgsConstructor;

/**
 * @author Thaliana
 *
 */
@AllArgsConstructor
public enum RoleUsuarioEnum {

	ADMIN("ROLE_", "ROLE_ADMIN"),
	USER("ROLE_", "ROLE_USER");
	
	private String prefijo;
	
	private String nombre;

	public String getPrefijo() {
		return prefijo;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
}
