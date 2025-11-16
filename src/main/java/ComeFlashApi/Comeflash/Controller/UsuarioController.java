package ComeFlashApi.Comeflash.Controller;
import ComeFlashApi.Comeflash.Assemblers.UsuarioModelAssembler;
import ComeFlashApi.Comeflash.Modelo.Usuario;
import ComeFlashApi.Comeflash.Service.UsuarioService;
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
@RequestMapping("/api/v1/usuario")
@Tag(name= "Usuario", description = "Operaciones con USUARIO")
public class UsuarioController {

    @Autowired
    UsuarioModelAssembler assembler;

    @Autowired
    public UsuarioService usuarioservice;


    @GetMapping
    @Operation(summary = "Obtener roles", description = "Obtener todos los roles registrados")
    @ApiResponse(responseCode = "200", description = "Operación exitosa: Se obtuvo todos los roles")
    @ApiResponse(responseCode = "404", description = "ERROR: No se listo los roles registrados")
    @ApiResponse(responseCode = "500", description = "ERROR: Fallo inesperado en el servidor")
    public ResponseEntity<CollectionModel<EntityModel<Usuario>>> getAll() {
        List<Usuario> lista = usuarioservice.getAll();
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
    public ResponseEntity<EntityModel<Usuario>> add(@RequestBody Usuario r) {
        Usuario lista = usuarioservice.add(r);
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
    public ResponseEntity<EntityModel<Usuario>> delete(
            @Parameter(name = "id", description = "El ID del rol a eliminar", example = "1")
            @PathVariable int id) {
        Usuario lista = usuarioservice.getId(id);
        if (lista != null) {
            usuarioservice.delete(id);
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
    public ResponseEntity<EntityModel<Usuario>> getId(
            @Parameter(name = "id", description = "El ID del rol a listar", example = "1")
            @PathVariable int id) {
        Usuario lista = usuarioservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>(assembler.toModel(lista), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}