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
import co.udea.arquitectura.model.EncabezadoPedido;
import co.udea.arquitectura.model.Producto;
import co.udea.arquitectura.service.EncabezadoPedidoService;
import co.udea.arquitectura.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pedido")
public class EncabezadoPedidoController {
	
	private static Logger log = LoggerFactory.getLogger(EncabezadoPedidoController.class);
	
	private EncabezadoPedidoService encabezadoPedidoService;
	
	@Autowired
    private Messages messages;	
	
	public EncabezadoPedidoController(EncabezadoPedidoService encabezadoPedido) {
		this.encabezadoPedidoService = encabezadoPedido;
	}
	
	@GetMapping(value = "consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar EncabezadoPedido por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "EncabezadoPedido encontrado", response = EncabezadoPedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<EncabezadoPedido> getEncabezadoPedido( @PathVariable("id") int id){
		 log.debug("REST request getEncabezadoPedido id : {}", id);
		return ResponseEntity.ok(encabezadoPedidoService.getEncabezadoPedido(id));
	}
	
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los EncabezadoPedido fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<EncabezadoPedido>> getEncabezadosPedidos(){
		log.debug("REST request listar todos los Pedidos");
		return ResponseEntity.ok(encabezadoPedidoService.getEncabezadosPedidos());		
	}
	
	@DeleteMapping(value = "borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borrar EncabezadoPedido por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "EncabezadoPedido Borrado", response = EncabezadoPedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteEncabezadoPedidoId( @PathVariable("id") int id){
		 log.debug("REST request deleteProducto id : {}", id);
		 encabezadoPedidoService.deleteEncabezadoPedidoId(id);
	}
	
	@PutMapping(value = "actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar EncabezadoPedido", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "EncabezadoPedido actualizado", response = EncabezadoPedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void updateEncabezadoPedido(@RequestBody EncabezadoPedido pedido ){
		 log.debug("REST request updateEncabezadoPedido id : {}", pedido.getId());
		encabezadoPedidoService.updateEncabezadoPedido(pedido);
	}
	
	@RequestMapping(value="crear", method=RequestMethod.POST)
	public EncabezadoPedido addEncabezadoPedido(@RequestBody EncabezadoPedido pedido) throws DataNotFoundException{
		log.debug("Entro a crear");
		if(pedido == null){
			throw new DataNotFoundException(messages.get("exception.data_not_found.pedido"));
		}
		return encabezadoPedidoService.addEncabezadoPedido(pedido);		
		
	}

}
