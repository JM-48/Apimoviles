package CatalogoAPI.ApiAppMoviles.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CatalogoAPI.ApiAppMoviles.Modelo.Rol;
import CatalogoAPI.ApiAppMoviles.Modelo.Usuario;
import CatalogoAPI.ApiAppMoviles.Repository.RolRepository;
import CatalogoAPI.ApiAppMoviles.Repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    // Listar
    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    // Listar por id
    public Usuario getId(int id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario add(Usuario usuario) {
        if (usuario.getRol() == null) {
            Rol rolCliente = rolRepository.findByNombre("CLIENTE");
            if (rolCliente == null) {
                rolCliente = new Rol();
                rolCliente.setNombre("CLIENTE");
                rolCliente = rolRepository.save(rolCliente);
            }
            usuario.setRol(rolCliente);
        } else {
            int rolId = usuario.getRol().getId();
            Rol rolBD = rolRepository.findById(rolId)
                    .orElseThrow(() -> new RuntimeException("El rol con id " + rolId + " no existe en la base de datos"));
            usuario.setRol(rolBD);
        }
        return usuarioRepository.save(usuario);
    }

    // Eliminar
    public String delete(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return "Usuario eliminado";
        } else {
            return "Usuario no existe";
        }
    }

    // Actualizar
    public Usuario update(int id, Usuario usuario) {
        if (usuarioRepository.existsById(id)) {
            Usuario update = usuarioRepository.findById(id).get();
            update.setNombre(usuario.getNombre());
            update.setContrasena(usuario.getContrasena());
            update.setCorreo(usuario.getCorreo());
            update.setRol(usuario.getRol());
            return usuarioRepository.save(update);
        } else {
            return null;
        }
    }

    public Usuario getByCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null);
    }
}
