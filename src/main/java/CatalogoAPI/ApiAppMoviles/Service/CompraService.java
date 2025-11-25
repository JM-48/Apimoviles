package CatalogoAPI.ApiAppMoviles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CatalogoAPI.ApiAppMoviles.Modelo.Compra;
import CatalogoAPI.ApiAppMoviles.Modelo.Productos;
import CatalogoAPI.ApiAppMoviles.Repository.CompraRepository;

import java.util.List;

@Service
public class CompraService {

    @Autowired
    public CompraRepository compraRepository;

    //Listar
    public List<Compra> getAll() {
        return compraRepository.findAll();
    }

    //Listar por id
    public Compra getId(int id) {
        return compraRepository.findById(id).get();
    }


    //Agregar
    public Compra add(Compra rol) {
        return compraRepository.save(rol);

    }

    public Compra update(int id, Compra compra) {
        if (compraRepository.existsById(id)) {
            Compra update = compraRepository.findById(id).get();
            update.setDetalles(compra.getDetalles(  ));
            update.setTotal(compra.getTotal());
            return compraRepository.save(update);
        } else {
            return null;
        }

    }

    //Eliminar
    public String delete(int id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return "Compra eliminado";
        } else {
            return "Compra no existe";
        }
    }


}
