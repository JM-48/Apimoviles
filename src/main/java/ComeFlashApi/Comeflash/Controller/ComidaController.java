package ComeFlashApi.Comeflash.Controller;


import ComeFlashApi.Comeflash.Assemblers.ComidaModelAssembler;
import ComeFlashApi.Comeflash.Modelo.Comida;
import ComeFlashApi.Comeflash.Modelo.Compra;
import ComeFlashApi.Comeflash.Service.ComidaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comidas") // Nueva URL para comidas
@Tag(name= "Comida", description = "Operaciones con COMIDAS")
public class ComidaController {

    @Autowired
    ComidaModelAssembler assembler;

    @Autowired
    public ComidaService comidaservice;


    @GetMapping
    @Operation(summary = "Obtener Comidas", description = "Obtener todos los Comidas registrados")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se obtuvo todos los Comidas")
    @ApiResponse(responseCode = "404", description = "ERROR: No se listo los Comidas registrados")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<List<Comida>> getAll() {
        List<Comida> lista = comidaservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    @Operation(summary = "Agregar Comidas", description = "Registrar Comidas al sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se agrego la comida")
    @ApiResponse(responseCode = "404", description = "ERROR: No se puedo agregar la comida")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<Comida>> add(@RequestBody Comida r) {
        Comida lista = comidaservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar Comidas", description = "Borrar Comidas que esten en el sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se borro la comida del sistema")
    @ApiResponse(responseCode = "404", description = "ERROR: No se pudo borrar la comida de sistema o no existe")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<Comida>> delete(
            @Parameter(name = "id", description = "El ID del rol a eliminar", example = "1")
            @PathVariable int id) {
        Comida lista = comidaservice.getId(id);
        if (lista != null) {
            comidaservice.delete(id);
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar comida por id", description = "Listar comida por id en el sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se listo la comida")
    @ApiResponse(responseCode = "404", description = "ERROR: No se listo la comida registrada")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<Comida>> getId(
            @Parameter(name = "id", description = "El ID de la comida a listar", example = "1")
            @PathVariable int id) {
        Comida lista = comidaservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    @Operation(summary = "Actualizar comida",description = "Actualizar datos de la comida registrada en sistema")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se actualizo la comida")
    @ApiResponse(responseCode = "404", description = "ERROR: No se actualizo la comida registrada")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<EntityModel<Comida>> update(@PathVariable int id, @RequestBody Comida update) {
        Comida lista=comidaservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(assembler.toModel(lista),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}