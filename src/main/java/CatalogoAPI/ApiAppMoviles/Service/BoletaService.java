package CatalogoAPI.ApiAppMoviles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CatalogoAPI.ApiAppMoviles.Modelo.Boleta;
import CatalogoAPI.ApiAppMoviles.Repository.BoletaReposity;

import java.util.List;
@Service
public class BoletaService {


    @Autowired
    public BoletaReposity boletaRepository;

    //Listar
    public List<Boleta> getAll() {
        return boletaRepository.findAll();
    }

    //Listar por id
    public Boleta getId(int id) {
        return boletaRepository.findById(id).get();
    }


    //Agregar
    public Boleta add(Boleta rol) {
        return boletaRepository.save(rol);

    }


    //Eliminar
    public String delete(int id) {
        if (boletaRepository.existsById(id)) {
            boletaRepository.deleteById(id);
            return "Boleta eliminado";
        } else {
            return "Boleta no existe";
        }
    }



    public List<Boleta> obtenerPorUsuario(int usuarioId) {
        return boletaRepository.findByUsuarioId(usuarioId);
    }

}
