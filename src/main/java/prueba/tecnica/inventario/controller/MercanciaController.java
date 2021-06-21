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
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;
import prueba.tecnica.inventario.service.MercanciaService;

import java.util.List;

@RestController
@RequestMapping("/mercancia")
public class MercanciaController {

    @Autowired
    private MercanciaService mercanciaService;

    @ApiOperation(value = "Permite insertar una mercancia en la base de datos.")
    @PostMapping("/save")
    public ResponseEntity<MensajeResponseDto> save(@RequestBody MercanciaEntity mercanciaEntity) throws Exception {
        MensajeResponseDto mensajeResponseDto = mercanciaService.save(mercanciaEntity);
        return new ResponseEntity<>(mensajeResponseDto, mensajeResponseDto.getStatus());
    }

    @ApiOperation(value = "Permite actualizar una mercancia en la base de datos.")
    @PutMapping("/update")
    public ResponseEntity<MensajeResponseDto> update(@RequestBody MercanciaEntity mercanciaEntity) throws Exception {
        MensajeResponseDto mensajeResponse = mercanciaService.update(mercanciaEntity);
        return new ResponseEntity<>(mensajeResponse, mensajeResponse.getStatus());
    }

    @ApiOperation(value = "Permite listar todas las mercancias de la base de datos.")
    @GetMapping("/findAll")
    public ResponseEntity<List<MercanciaEntity>> getAll() {
        List<MercanciaEntity> mercanciaEntities = mercanciaService.getAll();
        return new ResponseEntity<>(mercanciaEntities, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite buscar una mercancia en la base de datos dado un filtro.")
    @GetMapping("/find/{id}")
    public ResponseEntity<MercanciaEntity> getById(@PathVariable("id") Long id) {
        MercanciaEntity mercanciaEntity = mercanciaService.getFindById(id);
        return new ResponseEntity<>(mercanciaEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite eliminar una mercancia en la base de datos.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MensajeResponseDto> delete(@PathVariable("id") Long id, Long idUsuarioRegister) throws Exception {
        MensajeResponseDto deleteValidatorResponse = mercanciaService.delete(id, idUsuarioRegister);
        return new ResponseEntity<>(deleteValidatorResponse, deleteValidatorResponse.getStatus());
    }
}
