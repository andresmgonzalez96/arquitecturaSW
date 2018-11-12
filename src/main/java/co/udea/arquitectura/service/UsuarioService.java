package co.udea.arquitectura.service;

import java.util.List;

import co.udea.arquitectura.model.Usuario;

public interface UsuarioService {

	public List<Usuario> getUsuarios();

	public Usuario getUsuario(String id);

	public Usuario addUsuario(Usuario usuario);

	public Usuario updateUsuario(Usuario usuario);

	public void deleteUsuarioId(String id);

}
