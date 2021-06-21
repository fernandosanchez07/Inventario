package prueba.tecnica.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.tecnica.inventario.dao.CargoDao;
import prueba.tecnica.inventario.entity.CargoEntity;
import prueba.tecnica.inventario.exception.MessageNotFoundException;
import prueba.tecnica.inventario.service.CargoService;

import java.util.List;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao cargoDao;

    @Override
    public CargoEntity save(CargoEntity cargoEntity) {
        return cargoDao.save(cargoEntity);
    }

    @Override
    public CargoEntity update(CargoEntity cargoEntity) {
        return cargoDao.save(cargoEntity);
    }

    @Override
    public void delete(Long id) {
        cargoDao.deleteById(id);
    }

    @Override
    public List<CargoEntity> getAll() {
        return cargoDao.findAll();
    }

    @Override
    public CargoEntity getFindById(Long id) {
        return cargoDao.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("El tipo de usuario con id: " + id + " no se encuentra registrada"));
    }

}