package co.udea.arquitectura.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.udea.arquitectura.exception.DataNotFoundException;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.model.Usuario;
import co.udea.arquitectura.service.UsuarioService;
import co.udea.arquitectura.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	private static Logger log = LoggerFactory.getLogger(UsuarioController.class);
	
	private UsuarioService usuarioService;
	
	@Autowired
    private Messages messages;	
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value = "consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar usuario por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario encontrado", response = Usuario.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Usuario> getUsuario( @PathVariable("id") String id){
		 log.debug("REST request getUsuario id : {}", id);
		return ResponseEntity.ok(usuarioService.getUsuario(id));
	}
	
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los usuarios fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Usuario>> getUsuarios(){
		log.debug("REST request listar todos los productos");
		return ResponseEntity.ok(usuarioService.getUsuarios());		
	}
	
	@DeleteMapping(value = "borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borrar Usuario por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario Borrado", response = Usuario.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteUsuarioId( @PathVariable("id") String id){
		 log.debug("REST request deleteProducto id : {}", id);
		 usuarioService.deleteUsuarioId(id);
	}
	
	@PutMapping(value = "actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar Usuario", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Usuario actualizado", response = Usuario.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void updateUsuario(@RequestBody Usuario usuario ){
		 log.debug("REST request updateProyecto id : {}", usuario.getIdusuario());
		usuarioService.updateUsuario(usuario);
	}
	
	@RequestMapping(value="crear", method=RequestMethod.POST)
	public Usuario addUsuario(@RequestBody Usuario usuario) throws DataNotFoundException{
		log.debug("Entro a crear");
		if(usuario == null){
			throw new DataNotFoundException(messages.get("exception.data_not_found.usuario"));
		}
		return usuarioService.addUsuario(usuario);		
		
	}

}
