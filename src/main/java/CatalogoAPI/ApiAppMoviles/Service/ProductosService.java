package CatalogoAPI.ApiAppMoviles.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CatalogoAPI.ApiAppMoviles.Modelo.Productos;
import CatalogoAPI.ApiAppMoviles.Repository.ProductosRepository;

import java.util.List;

@Service
public class ProductosService {


    @Autowired
    public ProductosRepository productosRepository;

    //Listar
    public List<Productos> getAll() {
        return productosRepository.findAll();
    }

    //Listar por id
    public Productos getId(int id) {
        return productosRepository.findById(id).orElse(null);
    }


    //Agregar
    public Productos add(Productos rol) {
        return productosRepository.save(rol);

    }

    public Productos update(int id, Productos comida) {

        Productos update = productosRepository.findById(id).get();
        if (productosRepository.existsById(id)) {
            update.setNombre(comida.getNombre(  ));
            update.setPrecio(comida.getPrecio());
            update.setDescripcion(comida.getDescripcion());
            update.setOferta(comida.isOferta());


            return productosRepository.save(update);
        } else {
            return null;
        }

    }





    //Eliminar
    public String delete(int id) {
        if (productosRepository.existsById(id)) {
            productosRepository.deleteById(id);
            return "Producto eliminado";
        } else {
            return "Producto no existe";
        }
    }


}
