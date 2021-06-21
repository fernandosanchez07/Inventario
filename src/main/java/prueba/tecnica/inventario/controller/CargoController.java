package prueba.tecnica.inventario.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prueba.tecnica.inventario.entity.CargoEntity;
import prueba.tecnica.inventario.service.CargoService;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @ApiOperation(value = "Permite insertar un cargo en la base de datos.")
    @PostMapping("/save")
    public ResponseEntity<CargoEntity> save(@RequestBody CargoEntity cargoEntity) {
        CargoEntity cargoSave = cargoService.save(cargoEntity);
        return new ResponseEntity<>(cargoSave, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Permite actualizar un cargo en la base de datos.")
    @PutMapping("/update")
    public ResponseEntity<CargoEntity> update(@RequestBody CargoEntity cargoEntity) {
        CargoEntity cargoUpdate = cargoService.update(cargoEntity);
        return new ResponseEntity<>(cargoUpdate, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite listar todos los cargos de la base de datos.")
    @GetMapping("/findAll")
    public ResponseEntity<List<CargoEntity>> getAll() {
        List<CargoEntity> mercanciaEntities = cargoService.getAll();
        return new ResponseEntity<>(mercanciaEntities, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite buscar un cargo en la base de datos dado un filtro.")
    @GetMapping("/find/{id}")
    public ResponseEntity<CargoEntity> getById(@PathVariable("id") Long id) {
        CargoEntity cargoEntity = cargoService.getFindById(id);
        return new ResponseEntity<>(cargoEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite eliminar un cargo de la base de datos.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        CargoEntity cargoEntity = cargoService.getFindById(id);
        if (cargoEntity == null) {
            throw new Exception("No se encontro el ID");
        }
        cargoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
