package co.udea.arquitectura.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Usuario;
import co.udea.arquitectura.repository.PersonaRepositoy;
import co.udea.arquitectura.repository.UsuarioRepositoy;
import co.udea.arquitectura.service.PersonaService;
import co.udea.arquitectura.service.UsuarioService;
import co.udea.arquitectura.util.Messages;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final Logger log = LoggerFactory.getLogger(UsuarioServiceImpl.class);
	
	private Messages messages;	
	private UsuarioRepositoy usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepositoy usuarioRepository, Messages messages) {
		this.usuarioRepository = usuarioRepository;
		this.messages = messages;
	}

	@Override
	public List<Usuario> getUsuarios() {
		log.debug("Inicio getUsuarios");
		List<Usuario> usuarios = usuarioRepository.findAll();
		log.debug("Fin getUsuarios");
		return usuarios;
	}
	
	@Override
	public Usuario getUsuario(String id) {
		log.debug("Inicio getUsuario: id = {}", id);
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin getUsuario: usuario = {}", usuario.get());
		return usuario.get();
	}
	
	
	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario addUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public void deleteUsuarioId(String id) {
		log.debug("Inicio deleteUsuarioId: id = {}", id);
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if(!usuario.isPresent()){
			throw new DataNotFoundException(messages.get("exception.data_not_found.demo"));
		}
		log.debug("Fin deleteUsuarioId: usuario = {}", usuario.get());
		usuarioRepository.delete(usuario.get());		
	}


}
