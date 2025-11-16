package ComeFlashApi.Comeflash.Assemblers;
import ComeFlashApi.Comeflash.Controller.RolController;
import ComeFlashApi.Comeflash.Modelo.Rol;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



@Component
public class RolModelAssembler implements RepresentationModelAssembler<Rol, EntityModel<Rol>>{
    @Override
    public EntityModel<Rol> toModel(Rol rol) {
        return EntityModel.of(rol,
                linkTo(methodOn(RolController.class).getId(rol.getId())).withRel("GETID"),
                linkTo(methodOn(RolController.class).delete(rol.getId())).withRel("DELETE"),
                linkTo(methodOn(RolController.class).getAll()).withRel("GET")

        );
    }
}

