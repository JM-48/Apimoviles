package CatalogoAPI.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CatalogoAPI.ApiAppMoviles.Modelo.Boleta;

import java.util.List;

@Repository
public interface BoletaReposity extends JpaRepository<Boleta, Integer> {
    List<Boleta> findByUsuarioId(int usuarioId);
}
