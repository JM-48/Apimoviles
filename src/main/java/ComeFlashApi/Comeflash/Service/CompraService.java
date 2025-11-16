package ComeFlashApi.Comeflash.Service;

import ComeFlashApi.Comeflash.Modelo.Compra;
import ComeFlashApi.Comeflash.Repository.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
