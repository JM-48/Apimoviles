package CatalogoAPI.ApiAppMoviles.Controller;

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

import CatalogoAPI.ApiAppMoviles.Assemblers.DetalleCompraAssembler;
import CatalogoAPI.ApiAppMoviles.Modelo.Compra;
import CatalogoAPI.ApiAppMoviles.Modelo.DetalleCompra;
import CatalogoAPI.ApiAppMoviles.Service.DetalleCompraService;

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
    public ResponseEntity<List<DetalleCompra>> getAll() {
        List<DetalleCompra> lista = detalleCompraservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<DetalleCompra> add(@RequestBody DetalleCompra r) {
        DetalleCompra lista = detalleCompraservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        DetalleCompra lista = detalleCompraservice.getId(id);
        if (lista != null) {
            detalleCompraservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCompra> getId(@PathVariable int id) {
        DetalleCompra lista = detalleCompraservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<DetalleCompra> update(@PathVariable int id, @RequestBody DetalleCompra update) {
        DetalleCompra lista=detalleCompraservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
