package prueba.tecnica.inventario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.tecnica.inventario.entity.UsuarioEntity;

public interface UsuarioDao extends JpaRepository<UsuarioEntity, Long> {

}
