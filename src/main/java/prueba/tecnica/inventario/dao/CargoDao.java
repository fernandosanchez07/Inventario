package prueba.tecnica.inventario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.tecnica.inventario.entity.CargoEntity;

public interface CargoDao extends JpaRepository<CargoEntity, Long> {

}
