package ComeFlashApi.Comeflash.Controller;

import ComeFlashApi.Comeflash.Assemblers.RolModelAssembler;
import ComeFlashApi.Comeflash.Modelo.DetalleCompra;
import ComeFlashApi.Comeflash.Modelo.Rol;
import ComeFlashApi.Comeflash.Service.RolService;
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
@RequestMapping("/api/v1/rol")
@Tag(name="Rol", description = "Funcionalidades de rol")
public class RolController {
    @Autowired
    RolModelAssembler assembler;

    @Autowired
    public RolService rolservice;


    @GetMapping
    public ResponseEntity<List<Rol>> getAll() {
        List<Rol> lista = rolservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Rol> add(@RequestBody Rol r) {
        Rol lista = rolservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Rol lista = rolservice.getId(id);
        if (lista != null) {
            rolservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getId(@PathVariable int id) {
        Rol lista = rolservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Rol> update( @PathVariable int id, Rol update) {
        Rol lista=rolservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
