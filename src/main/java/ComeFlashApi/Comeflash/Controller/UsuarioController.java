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
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> lista = usuarioservice.getAll();
        if (lista.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
    }


    @PostMapping
    public ResponseEntity<Usuario> add(@RequestBody Usuario r) {
        Usuario lista = usuarioservice.add(r);
        if (lista != null) {
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        Usuario lista = usuarioservice.getId(id);
        if (lista != null) {
            usuarioservice.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getId(@PathVariable int id) {
        Usuario lista = usuarioservice.getId(id);
        if (lista != null) {
            return new ResponseEntity<>( lista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable int id, Usuario update) {
        Usuario lista=usuarioservice.update(id,update);
        if(lista!=null){
            return new ResponseEntity<>(lista,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}