/**
 * 
 */
package com.thali.ws.inmo.mother.conf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import com.thali.ws.inmo.mother.util.enums.RoleUsuarioEnum;

/**
 * @author Thaliana
 *
 */
@Component
public class EndPointConfigComponent {

	@Value("${inmo.mother.endpoint.all.arrendatario}")
	private String endPointAllArrendatario;

	@Value("${inmo.mother.endpoint.one.arrendatario}")
	private String endPointOneArrendatario;

	@Value("${inmo.mother.endpoint.all.propietario}")
	private String endPointAllPropietario;

	@Value("${inmo.mother.endpoint.one.propietario}")
	private String endPointOnePropietario;

	@Value("${inmo.mother.endpoint.all.contrato}")
	private String endPointAllContrato;

	@Value("${inmo.mother.endpoint.one.contrato}")
	private String endPointOneContrato;

	@Value("${inmo.mother.endpoint.all.pagocontrato}")
	private String endPointAllPagoContrato;

	@Value("${inmo.mother.endpoint.one.pagocontrato}")
	private String endPointOnePagoContrato;

	@Value("${inmo.mother.endpoint.server.web.client}")
	private String endPointServerWebClient;

	public String[] endPointPermitAll() {
		String[] endpoints = { endPointAllArrendatario, endPointAllPropietario };
		return endpoints;
	}

	public String[] endPointPermitOfRole(RoleUsuarioEnum roleUsuarioEnum) {
		List<String> listEndPoints = new ArrayList<>();
		switch (roleUsuarioEnum) {
		case ADMIN:
			listEndPoints = Arrays.asList(this.endPointAllContrato, this.endPointAllPagoContrato,
					this.endPointOneArrendatario, this.endPointOneContrato, this.endPointOnePagoContrato,
					this.endPointOnePropietario);
			break;

		case USER:
			listEndPoints = Arrays.asList(this.endPointOneArrendatario, this.endPointOneContrato,
					this.endPointOnePagoContrato, this.endPointOnePropietario);
			break;

		default:
			break;
		}

		String[] endPoints = new String[listEndPoints.size()];
		return listEndPoints.toArray(endPoints);
	}

	public List<String> endPointServerOriginClients() {
		return Arrays.asList(this.endPointServerWebClient);
	}

	public List<String> methodsHttpRegister() {
		return Arrays.asList(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PATCH.name(),
				HttpMethod.OPTIONS.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name());
	}
	
	public List<String> headersHttpRegister() {
		return Arrays.asList("content-type", "Authorization");
	}

}
