package CatalogoAPI.ApiAppMoviles.Assemblers;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import CatalogoAPI.ApiAppMoviles.Controller.CompraController;
import CatalogoAPI.ApiAppMoviles.Controller.DetalleCompraController;
import CatalogoAPI.ApiAppMoviles.Modelo.DetalleCompra;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class DetalleCompraAssembler implements RepresentationModelAssembler<DetalleCompra, EntityModel<DetalleCompra>> {
    @Override
    public EntityModel<DetalleCompra> toModel(DetalleCompra detalleCompra) {
        return EntityModel.of(detalleCompra,
                linkTo(methodOn(DetalleCompraController.class).getId(detalleCompra.getId())).withRel("GETID"),
                linkTo(methodOn(DetalleCompraController.class).delete(detalleCompra.getId())).withRel("DELETE"),
                linkTo(methodOn(DetalleCompraController.class).getAll()).withRel("GET"),
                linkTo(methodOn(DetalleCompraController.class).update(detalleCompra.getId(), detalleCompra)).withRel("PUT")

        );
    }

}
