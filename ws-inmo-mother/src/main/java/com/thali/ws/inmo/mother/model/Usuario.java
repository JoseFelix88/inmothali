package com.thali.ws.inmo.mother.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigoUsuario;
	
	@Column(unique = true, length = 20)
	private String userName;
	
	@Column(length = 60) 
	private String password;
	
	private Boolean enabled;
	
	private String nombres;
	
	private String apellidos;
	
	@Column(unique = true)
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Role> roles;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969560727030993043L;

}
