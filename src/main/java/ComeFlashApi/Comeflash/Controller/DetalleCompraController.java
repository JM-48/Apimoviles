package ComeFlashApi.Comeflash.Controller;

import ComeFlashApi.Comeflash.Assemblers.DetalleCompraAssembler;
import ComeFlashApi.Comeflash.Modelo.Compra;
import ComeFlashApi.Comeflash.Modelo.DetalleCompra;
import ComeFlashApi.Comeflash.Service.DetalleCompraService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/DetalleCompra")
@Tag(name="Detalle Compra", description = "Funcionalidades de DetalleCompra")
public class DetalleCompraController {


    @Autowired
    DetalleCompraAssembler assembler;

    @Autowired
    public DetalleCompraService detalleCompraservice;


    @GetMapping
    @Operation(summary = "Obtener roles", description = "Obtener todos los roles registrados")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se obtuvo todos los roles")
    @ApiResponse(responseCode = "404", description = "ERROR: No se listo los roles registrados")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<CollectionModel<EntityModel<DetalleCompra>>> getAll() {
        List<DetalleCompra> lista = detalleCompraservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(assembler.toCollectionModel(lista), HttpStatus.OK);
        }
    }


    @PostMapping
    @Operation(summary = "Agregar roles", description = "Registrar roles al sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se agrego el rol")
    @ApiResponse(responseCode = "404", description = "ERROR: No se puedo agregar el rol")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<DetalleCompra>> add(@RequestBody DetalleCompra r) {
        DetalleCompra lista = detalleCompraservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar roles", description = "Borrar roles que esten en el sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se borro rol del sistema")
    @ApiResponse(responseCode = "404", description = "ERROR: No se pudo borrar rol de sistema o no existe")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<DetalleCompra>> delete(
            @Parameter(name = "id", description = "El ID del rol a eliminar", example = "1")
            @PathVariable int id) {
        DetalleCompra lista = detalleCompraservice.getId(id);
        if (lista != null) {
            detalleCompraservice.delete(id);
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/{id}")
    @Operation(summary = "Listar rol por id", description = "Listar rol por id en el sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se listo la rol")
    @ApiResponse(responseCode = "404", description = "ERROR: No se listo la rol registrada")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<DetalleCompra>> getId(
            @Parameter(name = "id", description = "El ID del rol a listar", example = "1")
            @PathVariable int id) {
        DetalleCompra lista = detalleCompraservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar compra",description = "Actualizar datos del detalle de la compra registrada en sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se actualizo el detalle de la compra")
    @ApiResponse(responseCode = "404", description = "ERROR: No se actualizo el detalle de la compra registrada")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<DetalleCompra>> update(@PathVariable int id, @RequestBody DetalleCompra update) {
        DetalleCompra lista=detalleCompraservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(assembler.toModel(lista),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
