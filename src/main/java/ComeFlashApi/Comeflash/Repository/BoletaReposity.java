package ComeFlashApi.Comeflash.Repository;

import ComeFlashApi.Comeflash.Modelo.Boleta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletaReposity extends JpaRepository<Boleta, Integer> {
    List<Boleta> findByUsuarioId(int usuarioId);
}
