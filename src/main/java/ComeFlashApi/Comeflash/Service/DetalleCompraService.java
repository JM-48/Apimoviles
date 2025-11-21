package ComeFlashApi.Comeflash.Service;
import ComeFlashApi.Comeflash.Modelo.Comida;
import ComeFlashApi.Comeflash.Modelo.Compra;
import ComeFlashApi.Comeflash.Modelo.DetalleCompra;
import ComeFlashApi.Comeflash.Repository.CompraRepository;
import ComeFlashApi.Comeflash.Repository.DetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return detalleCompraRepository.findById(id).get();
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
