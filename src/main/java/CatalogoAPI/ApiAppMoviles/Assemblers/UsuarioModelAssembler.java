package ComeFlashApi.ApiAppMoviles.Assemblers;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ComeFlashApi.ApiAppMoviles.Controller.RolController;
import ComeFlashApi.ApiAppMoviles.Controller.UsuarioController;
import ComeFlashApi.ApiAppMoviles.Modelo.Usuario;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class UsuarioModelAssembler implements RepresentationModelAssembler<Usuario, EntityModel<Usuario>>{
    @Override
    public EntityModel<Usuario> toModel(Usuario usuario) {
        return EntityModel.of(usuario,
                linkTo(methodOn(UsuarioController.class).getId(usuario.getId())).withRel("GETID"),
                linkTo(methodOn(UsuarioController.class).delete(usuario.getId())).withRel("DELETE"),
                linkTo(methodOn(UsuarioController.class).getAll()).withRel("GET"),
                linkTo(methodOn(UsuarioController.class).update(usuario.getId(), usuario)).withRel("PUT")

        );
    }
}
