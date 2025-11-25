package CatalogoAPI.ApiAppMoviles.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CatalogoAPI.ApiAppMoviles.Modelo.ItemCompra;
import CatalogoAPI.ApiAppMoviles.Service.ItemCompraService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/itemCompra")
@Tag(name= "ItemCompra", description = "Operaciones con ItemCompra")

public class ItemCompraController {

    @Autowired
    public ItemCompraService boletaService;


    @GetMapping
    public ResponseEntity<List<ItemCompra>> getAll() {
        List<ItemCompra> lista = boletaService.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<ItemCompra> add(@RequestBody ItemCompra r) {
        ItemCompra lista = boletaService.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        ItemCompra lista = boletaService.getId(id);
        if (lista != null) {
            boletaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCompra> getId(@PathVariable int id) {
        ItemCompra lista = boletaService.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
