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
    public ResponseEntity<List<Comida>> getAll() {
        List<Comida> lista = comidaservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Comida> add(@RequestBody Comida r) {
        Comida lista = comidaservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Comida lista = comidaservice.getId(id);
        if (lista != null) {
            comidaservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comida> getId(@PathVariable int id) {
        Comida lista = comidaservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Comida> update( @PathVariable int id, Comida update) {
        Comida lista=comidaservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}