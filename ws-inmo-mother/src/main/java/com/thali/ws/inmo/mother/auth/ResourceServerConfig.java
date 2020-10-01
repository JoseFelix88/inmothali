/**
 * 
 */
package com.thali.ws.inmo.mother.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.thali.ws.inmo.mother.conf.EndPointConfigComponent;
import com.thali.ws.inmo.mother.util.enums.RoleUsuarioEnum;

/**
 * @author Thaliana
 *
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired 
	private EndPointConfigComponent endPointConfig;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, endPointConfig.endPointPermitAll())
				.permitAll()
				.antMatchers(HttpMethod.GET, endPointConfig.endPointPermitOfRole(RoleUsuarioEnum.ADMIN))
				.hasRole(RoleUsuarioEnum.ADMIN.name())
				.antMatchers(HttpMethod.GET, endPointConfig.endPointPermitOfRole(RoleUsuarioEnum.USER))
				.hasRole(RoleUsuarioEnum.USER.name())
				.antMatchers(HttpMethod.POST, endPointConfig.endPointPermitOfRole(RoleUsuarioEnum.ADMIN))
				.hasRole(RoleUsuarioEnum.ADMIN.name())
				.anyRequest().authenticated()
				.and()
				.cors().configurationSource(corsConfigurationSource());
	}

	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration cors = new CorsConfiguration();
		cors.setAllowedOrigins(endPointConfig.endPointServerOriginClients());
		cors.setAllowedMethods(endPointConfig.methodsHttpRegister());
		cors.setExposedHeaders(endPointConfig.headersHttpRegister());
		
		UrlBasedCorsConfigurationSource urlBaseCors = new UrlBasedCorsConfigurationSource();
		urlBaseCors.registerCorsConfiguration("/**", cors.applyPermitDefaultValues());
		return urlBaseCors;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return filter;
	}
	
}
