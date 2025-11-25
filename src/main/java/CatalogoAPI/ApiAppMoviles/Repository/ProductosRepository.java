package ComeFlashApi.ApiAppMoviles.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ComeFlashApi.ApiAppMoviles.Modelo.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}