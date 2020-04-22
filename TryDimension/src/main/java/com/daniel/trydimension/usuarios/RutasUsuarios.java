package com.daniel.trydimension.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.daniel.trydimension.servicios.ServicioCodigo;
import com.daniel.trydimension.servicios.ServicioNumeracion;

@Controller
public class RutasUsuarios {

	/**
	 * Inyecciones DAO
	 */
	@Autowired
	UsuarioDAO usuarioDAO;

	/**
	 * Inyecciones SERVICIOS
	 */
	@Autowired
	ServicioNumeracion servicioNumeracion;

	@Autowired
	ServicioCodigo servicioCodigo;

	/**
	 * PÁGINA INICIAL DE LA EMPRESA
	 * *****************************************************
	 */
	@GetMapping("/trydimensionhome")
	public ModelAndView trydimensionhome() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("homepage");

		return mav;
	}

	/**
	 * OTRA RUTA QUE REDIRIGE A LA PÁGINA PRINCIPAL
	 */
	@GetMapping("/")
	public ModelAndView trydimension() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("homepage");

		return mav;
	}

	/**
	 * FORMULARIO DE CONTACTO
	 * ***********************************************************
	 */
	@GetMapping("/trydimensionform")
	public ModelAndView trydimensionform() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("form");

		// Añade un objeto Usuario, y crea una lista de los mismos (Gracias al DAO)
		mav.addObject("unUsuario", new Usuario());
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDAO.findAll();
		mav.addObject("listaUsuarios", listaUsuarios);

		return mav;
	}

	/**
	 * POST PARA AÑADIR CLIENTES
	 */
	@PostMapping("/trydimensionform/addUser")
	public String usuariosAdd(@ModelAttribute Usuario usuario) {

		// Servicios para asignar posición y código alfanumérico
		usuario.setNumero(servicioNumeracion.obtenerNumero());
		usuario.setCodigo(servicioCodigo.obtenerCodigo());

		// Se encripta la contraseña 
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

		// El DAO se encarga directamente de almacenar el Usuario en la Base de Datos
		usuarioDAO.save(usuario);

		return "redirect:/trydimensionclients";
	}

	/**
	 * LISTA DE CLIENTES REGISTRADOS
	 * ****************************************************
	 */
	@GetMapping("/trydimensionclients")
	public ModelAndView trydimensionclients() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("clients");

		// Añade un objeto Usuario, y crea una lista de los mismos (Gracias al DAO)
		mav.addObject("unUsuario", new Usuario());
		List<Usuario> listaUsuarios = (List<Usuario>) usuarioDAO.findAll();
		mav.addObject("listaUsuarios", listaUsuarios);

		return mav;
	}

	/**
	 * RUTA GET PARA BORRAR USUARIOS
	 * ****************************************************
	 */
	@GetMapping("/trydimensionclients/delete/{id}")
	public String usuariosDelete(@PathVariable String id) {

		// El DAO se encarga directamente de borrar el Usuario de la Base de Datos
		usuarioDAO.deleteById(id);

		return "redirect:/trydimensionclients";
	}

	/**
	 * RUTA GET PARA EDITAR USUARIOS
	 * ****************************************************
	 */
	@PostMapping("/trydimensionclients/update/{id}")
	public ModelAndView usuariosUpdate(@PathVariable String id) {
		System.out.println("ta");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("clients");

		Usuario usuarioSeleccionado = usuarioDAO.findById(id).get();
		String username = usuarioSeleccionado.getUsername();
		String password = usuarioSeleccionado.getPassword();

		mav.addObject("usuarioSelect", usuarioSeleccionado);

		usuarioDAO.save(usuarioSeleccionado);

		return mav;
	}

}
