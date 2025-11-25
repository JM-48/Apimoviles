package ComeFlashApi.ApiAppMoviles.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ComeFlashApi.ApiAppMoviles.Modelo.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
