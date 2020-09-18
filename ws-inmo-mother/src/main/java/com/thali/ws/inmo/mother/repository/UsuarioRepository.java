/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.thali.ws.inmo.mother.model.Usuario;

/**
 * @author Thaliana
 *
 */
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {

	public Usuario findByUserName(String userName);
	
}
