package ComeFlashApi.Comeflash.Repository;


import ComeFlashApi.Comeflash.Modelo.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer> {

}