package CatalogoAPI.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CatalogoAPI.ApiAppMoviles.Modelo.ItemCompra;

@Repository
public interface ItemCompraRepository extends JpaRepository<ItemCompra, Integer> {
}
