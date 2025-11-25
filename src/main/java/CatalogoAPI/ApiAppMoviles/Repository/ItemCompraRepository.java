package ComeFlashApi.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ComeFlashApi.ApiAppMoviles.Modelo.ItemCompra;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
}
