package CatalogoAPI.ApiAppMoviles.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import CatalogoAPI.ApiAppMoviles.Modelo.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Integer> {

}
