package ComeFlashApi.Comeflash.Controller;


import ComeFlashApi.Comeflash.Assemblers.CompraModelAssembler;
import ComeFlashApi.Comeflash.Modelo.Comida;
import ComeFlashApi.Comeflash.Modelo.Compra;
import ComeFlashApi.Comeflash.Service.CompraService;
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
@RequestMapping("/api/v1/compra")
@Tag(name="compra", description = "Funcionalidades de compra")
public class CompraController {

    @Autowired
    CompraModelAssembler assembler;

    @Autowired
    public CompraService compraservice;


    @GetMapping
    public ResponseEntity<List<Compra>> getAll() {
        List<Compra> lista = compraservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Compra> add(@RequestBody Compra r) {
        Compra lista = compraservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Compra lista = compraservice.getId(id);
        if (lista != null) {
            compraservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getId(@PathVariable int id) {
        Compra lista = compraservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> update( @PathVariable int id, @RequestBody Compra update) {
        Compra lista=compraservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
