/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.Arrendatario;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "arrendatario")
public interface ArrendatarioRepository extends PagingAndSortingRepository<Arrendatario, Integer> {

}
