package prueba.tecnica.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prueba.tecnica.inventario.dao.UsuarioDao;
import prueba.tecnica.inventario.entity.UsuarioEntity;
import prueba.tecnica.inventario.exception.MessageNotFoundException;
import prueba.tecnica.inventario.service.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public UsuarioEntity save(UsuarioEntity usuarioEntity) {
        return usuarioDao.save(usuarioEntity);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity usuarioEntity) {
        return usuarioDao.save(usuarioEntity);
    }

    @Override
    public void delete(Long id) {
        usuarioDao.deleteById(id);
    }

    @Override
    public List<UsuarioEntity> getAll() {
        return usuarioDao.findAll();
    }

    @Override
    public UsuarioEntity getFindById(Long id) {
        return usuarioDao.findById(id)
                .orElseThrow(() -> new MessageNotFoundException("La usuario con id: " + id + " no se encuentra registrada"));
    }
}
