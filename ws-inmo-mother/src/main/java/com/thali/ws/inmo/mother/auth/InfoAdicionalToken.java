/**
 * 
 */
package com.thali.ws.inmo.mother.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.thali.ws.inmo.mother.model.Usuario;
import com.thali.ws.inmo.mother.service.UsuarioService;

/**
 * @author Thaliana
 *
 */
@Component
public class InfoAdicionalToken implements TokenEnhancer {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.findByUserName(authentication.getName());
		Map<String, Object> infoAdicionalToken = new HashMap<>();
		infoAdicionalToken.put("nombre_usuario", usuario.getCodigoUsuario() + " : " + usuario.getUserName());
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(infoAdicionalToken);
		return accessToken;
	}

}
