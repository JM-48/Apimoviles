package ComeFlashApi.Comeflash.Service;

import ComeFlashApi.Comeflash.Modelo.ItemCompra;
import ComeFlashApi.Comeflash.Repository.ItemCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemCompraService {

    @Autowired
    public ItemCompraRepository itemCompraRepository;

    //Listar
    public List<ItemCompra> getAll() {
        return itemCompraRepository.findAll();
    }

    //Listar por id
    public ItemCompra getId(int id) {
        return itemCompraRepository.findById(id).get();
    }


    //Agregar
    public ItemCompra add(ItemCompra rol) {
        return itemCompraRepository.save(rol);

    }




    //Eliminar
    public String delete(int id) {
        if (itemCompraRepository.existsById(id)) {
            itemCompraRepository.deleteById(id);
            return "ItemCompra eliminado";
        } else {
            return "ItemCompra no existe";
        }
    }
}
