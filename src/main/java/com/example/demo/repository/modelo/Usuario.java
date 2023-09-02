package com.example.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario_autenticacion")
@JsonIgnoreProperties(value = "")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarioautenticacion")
	@SequenceGenerator(name = "seq_usuarioautenticacion", sequenceName = "seq_usuarioautenticacion", allocationSize = 1)
	@Column(name = "usau_id")
	private Integer id;
	
	@Column(name = "usau_username")
	private String username;
	
	@Column(name = "usau_password")
	private String password;

	
	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
