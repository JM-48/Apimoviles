package CatalogoAPI.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CatalogoAPI.ApiAppMoviles.Modelo.DetalleCompra;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
}
