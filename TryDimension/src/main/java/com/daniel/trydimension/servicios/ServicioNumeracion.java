package com.daniel.trydimension.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daniel.trydimension.usuarios.Usuario;
import com.daniel.trydimension.usuarios.UsuarioDAO;

/**
 * SERVICIO QUE NUMERA LOS CLIENTES DEPENDIENDO DE SU POSICIÓN EN LA BASE DE
 * DATOS
 */
@Service
public class ServicioNumeracion {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public long obtenerNumero() {

		long numero = 1;

		Optional<Usuario> usuario = usuarioDAO.findByNumero(numero);

		while (usuario.isPresent()) {

			numero++;
			usuario = usuarioDAO.findByNumero(numero);

		}

		return numero;

	}

}
