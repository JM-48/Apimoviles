package ComeFlashApi.Comeflash.Assemblers;

import ComeFlashApi.Comeflash.Controller.DetalleCompraController;
import ComeFlashApi.Comeflash.Modelo.DetalleCompra;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
@Component
public class DetalleCompraAssembler implements RepresentationModelAssembler<DetalleCompra, EntityModel<DetalleCompra>> {
    @Override
    public EntityModel<DetalleCompra> toModel(DetalleCompra detalleCompra) {
        return EntityModel.of(detalleCompra,
                linkTo(methodOn(DetalleCompraController.class).getId(detalleCompra.getId())).withRel("GETID"),
                linkTo(methodOn(DetalleCompraController.class).delete(detalleCompra.getId())).withRel("DELETE"),
                linkTo(methodOn(DetalleCompraController.class).getAll()).withRel("GET")

        );
    }

}
