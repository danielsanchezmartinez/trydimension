package com.daniel.trydimension.usuarios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, String> {

	// Sentencias
	Optional<Usuario> findByNumero(Long numero);
	Optional<Usuario> findByCodigo(String codigo);

}
