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
import co.udea.arquitectura.model.DetallePedido;
import co.udea.arquitectura.model.EncabezadoPedido;
import co.udea.arquitectura.service.DetallePedidoService;
import co.udea.arquitectura.util.Messages;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/detallepedido")
public class DetallePedidoController {
	
	private static Logger log = LoggerFactory.getLogger(DetallePedidoController.class);
	
	private DetallePedidoService detallePedidoService;
	
	@Autowired
    private Messages messages;	
	
	public DetallePedidoController(DetallePedidoService detallePedido) {
		this.detallePedidoService = detallePedido;
	}
	
	@GetMapping(value = "consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Consultar DetallePedido por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedido encontrado", response = DetallePedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<DetallePedido> getDetallePedido( @PathVariable("id") int id){
		 log.debug("REST request getDetallePedido id : {}", id);
		return ResponseEntity.ok(detallePedidoService.getDetallePedido(id));
	}
	
	@GetMapping(value = "listar", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Buscar todos", response = Page.class)
	@ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los DetallePedido fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public ResponseEntity<List<DetallePedido>> getDetallesPedido(){
		log.debug("REST request listar todos los Detalle Pedidos");
		return ResponseEntity.ok(detallePedidoService.getDetallesPedido());		
	}
	
	@DeleteMapping(value = "borrar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Borrar DetallePedido por id", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedido Borrado", response = DetallePedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void deleteDetallePedidoId( @PathVariable("id") int id){
		 log.debug("REST request deleteDetalle id : {}", id);
		 detallePedidoService.deleteDetallePedidoId(id);
	}
	
	@PutMapping(value = "actualizar/", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Actualizar DetallePedido", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "DetallePedido actualizado", response = DetallePedido.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 404, message = "Recurso no encontrado"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
	public void updateDetallePedido(@RequestBody DetallePedido detallePedido ){
		 log.debug("REST request updateDetallePedido id : {}", detallePedido.getIdDetalle());
		detallePedidoService.updateDetallePedido(detallePedido);
	}
	
	@RequestMapping(value="crear", method=RequestMethod.POST)
	public DetallePedido addDetallePedido(@RequestBody DetallePedido detallePedido) throws DataNotFoundException{
		log.debug("Entro a crear");
		if(detallePedido == null){
			throw new DataNotFoundException(messages.get("exception.data_not_found.detallepedido"));
		}
		return detallePedidoService.addDetallePedido(detallePedido);		
		
	}

}
