package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Usuario;
import com.example.demo.security.JwtUtils;
import com.example.demo.service.IUsuarioService;
import com.example.demo.service.to.UsuarioTo;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerResFul {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@PatchMapping
	public String obtenerToken(@RequestBody UsuarioTo usuario) {
		
		String jwtSecret = usuario.getJwtSecret();
	    int jwtExpiration = usuario.getJwtExpiration();
		
		
		this.authenticated(usuario.getUsername(), usuario.getPassword());
		
		
		return this.jwtUtils.generateJwtToken(usuario.getUsername());
		
	}
	
	private void authenticated(String usuario, String password) {
		Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void guardarUsuario(@RequestBody Usuario usuario) {
		this.usuarioService.guardarUsuario(usuario);
	}

}
