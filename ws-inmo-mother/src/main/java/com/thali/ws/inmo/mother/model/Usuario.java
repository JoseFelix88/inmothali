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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo_usuario", "codigo_role"})})
	private List<Role> roles;
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4969560727030993043L;

}
