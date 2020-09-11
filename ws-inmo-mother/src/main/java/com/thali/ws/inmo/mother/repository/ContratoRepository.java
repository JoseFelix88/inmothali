/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.Contrato;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "contrato")
public interface ContratoRepository extends PagingAndSortingRepository<Contrato, Integer> {

}
