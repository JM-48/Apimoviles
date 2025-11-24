package ComeFlashApi.Comeflash.Repository;

import ComeFlashApi.Comeflash.Modelo.ItemCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
}
