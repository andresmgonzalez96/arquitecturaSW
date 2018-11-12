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
import co.udea.arquitectura.model.Persona;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.service.PersonaService;
import co.udea.arquitectura.service.ProductoService;
import co.udea.arquitectura.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class PersonaController {
	
	private static Logger log = LoggerFactory.getLogger(PersonaController.class);
	
	private PersonaService clienteService;
	
	@Autowired
    private Messages messages;	
	
	public PersonaController(PersonaService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping(value = "consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar cliente por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente encontrado", response = Persona.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<Persona> getCliente( @PathVariable("id") String id){
		 log.debug("REST request getCliente id : {}", id);
		return ResponseEntity.ok(clienteService.getCliente(id));
	}
	
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los clientes fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<Persona>> getClientes(){
		log.debug("REST request listar todos los clientes");
		return ResponseEntity.ok(clienteService.getClientes());		
	}
	
	@DeleteMapping(value = "borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borrar cliente por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente Borrado", response = Persona.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteClienteId( @PathVariable("id") String id){
		 log.debug("REST request deleteCliente id : {}", id);
		 clienteService.deleteClienteId(id);
	}
	
	@PutMapping(value = "actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar Cliente", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cliente actualizado", response = Persona.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void updateCliente(@RequestBody Persona cliente ){
		 log.debug("REST request updateCliente id : {}", cliente.getId());
		clienteService.updateCliente(cliente);
	}
	
	@RequestMapping(value="crear", method=RequestMethod.POST)
	public Persona addCliente(@RequestBody Persona cliente) throws DataNotFoundException{
		log.debug("Entro a crear");
		if(cliente == null){
			throw new DataNotFoundException(messages.get("exception.data_not_found.cliente"));
		}
		return clienteService.addCliente(cliente);		
		
	}

}
