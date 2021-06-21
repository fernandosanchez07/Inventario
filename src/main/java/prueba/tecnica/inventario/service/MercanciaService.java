package prueba.tecnica.inventario.service;

import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

import java.util.List;

public interface MercanciaService {

    List<MercanciaEntity> getAll();

    MercanciaEntity getFindByNombre(String nombre);

    MercanciaEntity getFindById(Long id);

    MensajeResponseDto save(MercanciaEntity mercanciaEntity) throws Exception;

    MensajeResponseDto update(MercanciaEntity mercanciaEntity) throws Exception;

    MensajeResponseDto delete(Long id, Long id_usuario_register);


}
