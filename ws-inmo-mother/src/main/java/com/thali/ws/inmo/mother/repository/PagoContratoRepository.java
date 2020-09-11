/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.PagoContrato;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "pagocontrato")
public interface PagoContratoRepository extends PagingAndSortingRepository<PagoContrato, Integer> {

}
