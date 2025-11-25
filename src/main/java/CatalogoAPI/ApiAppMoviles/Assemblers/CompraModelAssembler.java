package CatalogoAPI.ApiAppMoviles.Assemblers;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import CatalogoAPI.ApiAppMoviles.Controller.CompraController;
import CatalogoAPI.ApiAppMoviles.Modelo.Compra;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class CompraModelAssembler implements RepresentationModelAssembler<Compra, EntityModel<Compra>> {
    @Override
    public EntityModel<Compra> toModel(Compra compra) {
        return EntityModel.of(compra,
                linkTo(methodOn(CompraController.class).getId(compra.getId())).withRel("GETID"),
                linkTo(methodOn(CompraController.class).delete(compra.getId())).withRel("DELETE"),
                linkTo(methodOn(CompraController.class).getAll()).withRel("GET"),
                linkTo(methodOn(CompraController.class).update(compra.getId(), compra)).withRel("PUT")

        );
    }
}
