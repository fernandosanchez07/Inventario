package prueba.tecnica.inventario.service;

import prueba.tecnica.inventario.entity.CargoEntity;

import java.util.List;

public interface CargoService {

    List<CargoEntity> getAll();

    CargoEntity getFindById(Long id);

    CargoEntity save(CargoEntity cargoEntity);

    CargoEntity update(CargoEntity cargoEntity);

    void delete(Long id);
}
