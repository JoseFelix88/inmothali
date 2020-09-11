/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.GastoContrato;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "gastocontrato")
public interface GastoContratoRepository extends PagingAndSortingRepository<GastoContrato, Integer> {

}
