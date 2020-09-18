/**
 * 
 */
package com.thali.ws.inmo.mother.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.thali.ws.inmo.mother.model.Usuario;
import com.thali.ws.inmo.mother.repository.UsuarioRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Thaliana
 *
 */
@Service
@Slf4j
public class UsuarioService implements UserDetailsService {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByUserName(username);
		if(ObjectUtils.isEmpty(usuario)) {
			log.error("Error: El usuario no existe en el sistema.");
			throw new UsernameNotFoundException("Error: El usuario no existe en el sistema."); 
		}
		log.info(usuario.toString());
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream().map(role -> new SimpleGrantedAuthority(role.getNombreRole()))
				.peek(autority -> log.info("Role: " + autority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUserName(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
	}

}
