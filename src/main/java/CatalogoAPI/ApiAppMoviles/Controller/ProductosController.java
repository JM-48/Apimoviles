package ComeFlashApi.ApiAppMoviles.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ComeFlashApi.ApiAppMoviles.Assemblers.ProductosModelAssembler;
import ComeFlashApi.ApiAppMoviles.Modelo.Compra;
import ComeFlashApi.ApiAppMoviles.Modelo.Productos;
import ComeFlashApi.ApiAppMoviles.Service.ProductosService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@Tag(name= "Productos", description = "Operaciones con PRODUCTOS")
public class ProductosController {

    @Autowired
    ProductosModelAssembler assembler;

    @Autowired
    public ProductosService productosservice;


    @GetMapping
    public ResponseEntity<List<Productos>> getAll() {
        List<Productos> lista = productosservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Productos> add(@RequestBody Productos r) {
        Productos lista = productosservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Productos lista = productosservice.getId(id);
        if (lista != null) {
            productosservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getId(@PathVariable int id) {
        Productos lista = productosservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Productos> update(@PathVariable int id, @RequestBody  Productos update) {
        Productos lista=productosservice.update(id,update);
        return (lista!=null)
            ?  new ResponseEntity<>(lista,HttpStatus.OK)
            :new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

}