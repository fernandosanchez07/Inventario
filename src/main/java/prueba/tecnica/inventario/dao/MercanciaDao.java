package prueba.tecnica.inventario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prueba.tecnica.inventario.entity.MercanciaEntity;

import java.util.Optional;

@Repository
public interface MercanciaDao extends JpaRepository<MercanciaEntity, Long> {

    Optional<MercanciaEntity> findByNombre(String nombre);
}
