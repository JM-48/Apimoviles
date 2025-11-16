package ComeFlashApi.Comeflash.Service;

import ComeFlashApi.Comeflash.Modelo.Usuario;
import ComeFlashApi.Comeflash.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {



    @Autowired
    public UsuarioRepository usuarioRepository;

    //Listar
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    //Listar por id
    public Usuario getId(int id) {
        return usuarioRepository.findById(id).get();
    }


    //Agregar
    public Usuario add(Usuario rol) {
        return usuarioRepository.save(rol);

    }

    //Eliminar
    public String delete(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Usuario eliminado";
        } else {
            return "Usuario no existe";
        }
    }





}






