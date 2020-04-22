package com.daniel.trydimension.servicios;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.trydimension.usuarios.Usuario;
import com.daniel.trydimension.usuarios.UsuarioDAO;

/**
 * SERVICIO QUE ASIGNA UN CÓDIGO ALFANUMÉRICO A CADA CLIENTE
 */
@Service
public class ServicioCodigo {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public String obtenerCodigo() {
		
		String codigo = "";
		
		Optional<Usuario> usuario = usuarioDAO.findByCodigo(codigo);
		
		while (usuario.isPresent()) {

			String letras[] = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z" };
			double letraAleatoriaA = Math.floor(Math.random() * (letras.length));
			double letraAleatoriaB = Math.floor(Math.random() * (letras.length));
			

			codigo += (int) Math.floor(Math.random() * 10);
			codigo += letras[(int) letraAleatoriaA];
			codigo += (int) Math.floor(Math.random() * 10);
			codigo += letras[(int) letraAleatoriaB];
			codigo += (int) Math.floor(Math.random() * 10);
			
		}
		
		return codigo;
	}
}
