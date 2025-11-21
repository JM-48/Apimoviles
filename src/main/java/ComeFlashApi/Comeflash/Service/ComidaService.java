package ComeFlashApi.Comeflash.Service;


import ComeFlashApi.Comeflash.Modelo.Comida;
import ComeFlashApi.Comeflash.Repository.ComidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComidaService {


    @Autowired
    public ComidaRepository comidaRepository;

    //Listar
    public List<Comida> getAll() {
        return comidaRepository.findAll();
    }

    //Listar por id
    public Comida getId(int id) {
        return comidaRepository.findById(id).get();
    }


    //Agregar
    public Comida add(Comida rol) {
        return comidaRepository.save(rol);

    }

    public Comida update(int id, Comida comida) {
        if (comidaRepository.existsById(id)) {
            Comida update = comidaRepository.findById(id).get();
            update.setNombre(comida.getNombre(  ));
            update.setPrecio(comida.getPrecio());
            update.setDescripcion(comida.getDescripcion());
            return comidaRepository.save(update);
        } else {
            return null;
        }

    }

    //Eliminar
    public String delete(int id) {
        if (comidaRepository.existsById(id)) {
            comidaRepository.deleteById(id);
            return "Comida eliminado";
        } else {
            return "Comida no existe";
        }
    }


}