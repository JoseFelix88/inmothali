/**
 * 
 */
package com.thali.ws.inmo.mother.service;

import com.thali.ws.inmo.mother.model.Usuario;

/**
 * @author Thaliana
 *
 */
public interface UsuarioService {

	public Usuario findByUserName(String userName);
}
