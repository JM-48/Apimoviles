package ComeFlashApi.ApiAppMoviles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ComeFlashApi.ApiAppMoviles.Modelo.*;
import ComeFlashApi.ApiAppMoviles.Repository.RolRepository;

import java.util.List;

@Service
public class RolService {


    @Autowired
    public RolRepository rolRepository;

    //Listar
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }

    //Listar por id
    public Rol getId(int id) {
        return rolRepository.findById(id).get();
    }


    //Agregar
    public Rol add(Rol rol) {
        return rolRepository.save(rol);

    }

    //Eliminar
    public String delete(int id) {
        if (rolRepository.existsById(id)) {
            rolRepository.deleteById(id);
            return "Rol eliminado";
        } else {
            return "Rol no existe";
        }
    }

    public Rol update(int id, Rol rol) {
        if (rolRepository.existsById(id)) {
            Rol update = rolRepository.findById(id).get();
            update.setNombre(rol.getNombre(  ));
            return rolRepository.save(update);
        } else {
            return null;
        }

    }

}