package com.daniel.trydimension.seguridad;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daniel.trydimension.usuarios.Usuario;
import com.daniel.trydimension.usuarios.UsuarioDAO;

@Service
public class Autenticacion implements UserDetailsService {

	@Autowired
	UsuarioDAO usuarioDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Usuario> miUsuario = usuarioDAO.findById(username);

		if (miUsuario.isPresent()) {

			return miUsuario.get();
			
		} else
			
			throw new UsernameNotFoundException("" + username);
	}

}
