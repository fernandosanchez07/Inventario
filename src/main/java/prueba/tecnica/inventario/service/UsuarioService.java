package prueba.tecnica.inventario.service;

import prueba.tecnica.inventario.entity.UsuarioEntity;

import java.util.List;

public interface UsuarioService {

    List<UsuarioEntity> getAll();

    UsuarioEntity getFindById(Long id);

    UsuarioEntity save(UsuarioEntity usuarioEntity);

    UsuarioEntity update(UsuarioEntity usuarioEntity);

    void delete(Long id);

}
