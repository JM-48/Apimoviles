package CatalogoAPI.ApiAppMoviles.Assemblers;


import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import CatalogoAPI.ApiAppMoviles.Controller.ProductosController;
import CatalogoAPI.ApiAppMoviles.Modelo.Productos;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class ProductosModelAssembler implements RepresentationModelAssembler<Productos, EntityModel<Productos>> {

    @Override
    public EntityModel<Productos> toModel(Productos comida) {
        return EntityModel.of(comida,
                linkTo(methodOn(ProductosController.class).getId(comida.getId())).withRel("GETID"),
                linkTo(methodOn(ProductosController.class).delete(comida.getId())).withRel("DELETE"),
                linkTo(methodOn(ProductosController.class).getAll()).withRel("GET"),
                linkTo(methodOn(ProductosController.class).update(comida.getId(), comida)).withRel("PUT")

        );
    }

}
