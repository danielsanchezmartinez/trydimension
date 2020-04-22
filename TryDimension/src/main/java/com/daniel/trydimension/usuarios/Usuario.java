package com.daniel.trydimension.usuarios;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {

	/**
	 * Variables de la Clase usuario
	 * ***************************************************
	 */
	@Id
	private String username;

	@Column
	private String password;

	@Column
	private String nombre;

	@Column
	private String apellido;

	@Column
	private String correo;

	@Column
	private Integer telefono;

	@Column
	private Long numero;

	@Column
	private String codigo;

	/**
	 * Getters y Setters de la Clase Usuario
	 * *******************************************
	 */
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * To String de la Clase Usuario
	 * ***************************************************
	 */
	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", nombre=" + nombre + ", apellido="
				+ apellido + ", correo=" + correo + ", telefono=" + telefono + ", numero=" + numero + ", codigo="
				+ codigo + "]";
	}

	/**
	 * Métodos User Details de la Clase Usuario
	 * ****************************************
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
