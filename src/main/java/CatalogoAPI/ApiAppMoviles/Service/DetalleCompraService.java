package CatalogoAPI.ApiAppMoviles.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CatalogoAPI.ApiAppMoviles.Modelo.Compra;
import CatalogoAPI.ApiAppMoviles.Modelo.DetalleCompra;
import CatalogoAPI.ApiAppMoviles.Modelo.Productos;
import CatalogoAPI.ApiAppMoviles.Repository.CompraRepository;
import CatalogoAPI.ApiAppMoviles.Repository.DetalleCompraRepository;

import java.util.List;
@Service
public class DetalleCompraService {

    @Autowired
    public DetalleCompraRepository detalleCompraRepository;
    @Autowired
    private CompraRepository compraRepository;

    //Listar
    public List<DetalleCompra> getAll() {
        return detalleCompraRepository.findAll();
    }

    //Listar por id
    public DetalleCompra getId(int id) {
        return detalleCompraRepository.findById(id).orElse(null);
    }


    //Agregar
    public DetalleCompra add(DetalleCompra rol) {
        return detalleCompraRepository.save(rol);

    }

    //Eliminar
    public String delete(int id) {
        if (detalleCompraRepository.existsById(id)) {
            detalleCompraRepository.deleteById(id);
            return "DetalleCompra eliminado";
        } else {
            return "DetalleCompra no existe";
        }
    }

    public DetalleCompra update(int id, DetalleCompra detalleCompra) {
        if (detalleCompraRepository.existsById(id)) {
            DetalleCompra update = detalleCompraRepository.findById(id).get();
            update.setCantidad(detalleCompra.getCantidad(  ));
            update.setSubtotal(detalleCompra.getSubtotal());
            update.setPrecioUnitario(detalleCompra.getPrecioUnitario());
            update.setNombreProducto(detalleCompra.getNombreProducto());
            return detalleCompraRepository.save(update);
        } else {
            return null;
        }

    }


}
