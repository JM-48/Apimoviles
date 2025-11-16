package ComeFlashApi.Comeflash.Repository;

import ComeFlashApi.Comeflash.Modelo.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
}
