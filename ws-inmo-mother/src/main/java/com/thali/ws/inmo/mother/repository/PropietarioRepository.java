/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.Propietario;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "propietario")
public interface PropietarioRepository extends PagingAndSortingRepository<Propietario, Integer> {

}
