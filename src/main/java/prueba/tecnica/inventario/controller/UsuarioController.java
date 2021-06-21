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
import prueba.tecnica.inventario.entity.UsuarioEntity;
import prueba.tecnica.inventario.service.UsuarioService;
import prueba.tecnica.inventario.service.impl.UsuarioServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioServiceImpl usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ApiOperation(value = "Permite insertar un usuario en la base de datos.")
    @PostMapping("/save")
    public ResponseEntity<UsuarioEntity> save(@RequestBody UsuarioEntity mercanciaEntity) {
        UsuarioEntity mercanciaSave = usuarioService.save(mercanciaEntity);
        return new ResponseEntity<>(mercanciaSave, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Permite actualizar un usuario en la base de datos.")
    @PutMapping("/update")
    public ResponseEntity<UsuarioEntity> update(@RequestBody UsuarioEntity mercanciaEntity) {
        UsuarioEntity mercanciaUpdate = usuarioService.update(mercanciaEntity);
        return new ResponseEntity<>(mercanciaUpdate, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite listar todos los usuarios de la base de datos.")
    @GetMapping("/findAll")
    public ResponseEntity<List<UsuarioEntity>> getAll() {
        List<UsuarioEntity> listUsuarios = usuarioService.getAll();
        return new ResponseEntity<>(listUsuarios, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite buscar un usuario en la base de datos, dado un filtro.")
    @GetMapping("/find/{id}")
    public ResponseEntity<UsuarioEntity> getById(@PathVariable("id") Long id) {
        UsuarioEntity mercanciaEntity = usuarioService.getFindById(id);
        return new ResponseEntity<>(mercanciaEntity, HttpStatus.OK);
    }

    @ApiOperation(value = "Permite borrar un usuario en la base de datos.")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
        UsuarioEntity usuarioEntity = usuarioService.getFindById(id);
        if(usuarioEntity == null){
            throw new Exception("No se encontro el ID");
        }
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

