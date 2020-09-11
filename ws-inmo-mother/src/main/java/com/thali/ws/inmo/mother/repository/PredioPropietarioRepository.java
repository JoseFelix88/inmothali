/**
 * 
 */
package com.thali.ws.inmo.mother.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.thali.ws.inmo.mother.model.PredioPropietario;

/**
 * @author Thaliana
 *
 */
@RepositoryRestResource(path = "prediopropietario")
public interface PredioPropietarioRepository extends PagingAndSortingRepository<PredioPropietario, Integer> {

}
