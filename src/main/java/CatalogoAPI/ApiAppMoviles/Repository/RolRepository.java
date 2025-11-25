package CatalogoAPI.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CatalogoAPI.ApiAppMoviles.Modelo.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNombre(String nombre);
}
