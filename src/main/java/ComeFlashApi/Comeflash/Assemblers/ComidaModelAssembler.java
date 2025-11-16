package ComeFlashApi.Comeflash.Assemblers;


import ComeFlashApi.Comeflash.Controller.ComidaController;
import ComeFlashApi.Comeflash.Modelo.Comida;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ComidaModelAssembler implements RepresentationModelAssembler<Comida, EntityModel<Comida>> {

    @Override
    public EntityModel<Comida> toModel(Comida comida) {
        return EntityModel.of(comida,
                linkTo(methodOn(ComidaController.class).getId(comida.getId())).withRel("GETID"),
                linkTo(methodOn(ComidaController.class).delete(comida.getId())).withRel("DELETE"),
                linkTo(methodOn(ComidaController.class).getAll()).withRel("GET")

        );
    }

}