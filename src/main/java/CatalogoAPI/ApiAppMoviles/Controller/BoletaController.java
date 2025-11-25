package CatalogoAPI.ApiAppMoviles.Controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import CatalogoAPI.ApiAppMoviles.Modelo.Boleta;
import CatalogoAPI.ApiAppMoviles.Service.BoletaService;

import java.util.List;
@RestController
@RequestMapping("/api/v1/boleta")
@Tag(name= "Boleta", description = "Operaciones con boleta")
public class BoletaController {



    @Autowired
    public BoletaService boletaService;


    @GetMapping
    public ResponseEntity<List<Boleta>> getAll() {
        List<Boleta> lista = boletaService.getAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Boleta> add(@RequestBody Boleta r) {
        Boleta lista = boletaService.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Boleta lista = boletaService.getId(id);
        if (lista != null) {
            boletaService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> getId(@PathVariable int id) {
        Boleta lista = boletaService.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/usuario/{usuarioId}")
    public List<Boleta> obtenerBoletasPorUsuario(@PathVariable int usuarioId) {
        return boletaService.obtenerPorUsuario(usuarioId);
    }


}
