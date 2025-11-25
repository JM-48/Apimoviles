package ComeFlashApi.ApiAppMoviles.Assemblers;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import ComeFlashApi.ApiAppMoviles.Controller.ComidaController;
import ComeFlashApi.ApiAppMoviles.Modelo.Productos;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ComidaModelAssembler implements RepresentationModelAssembler<Productos, EntityModel<Productos>> {

    @Override
    public EntityModel<Productos> toModel(Productos comida) {
        return EntityModel.of(comida,
                linkTo(methodOn(ComidaController.class).getId(comida.getId())).withRel("GETID"),
                linkTo(methodOn(ComidaController.class).delete(comida.getId())).withRel("DELETE"),
                linkTo(methodOn(ComidaController.class).getAll()).withRel("GET"),
                linkTo(methodOn(ComidaController.class).update(comida.getId(), comida)).withRel("PUT")

        );
    }

}