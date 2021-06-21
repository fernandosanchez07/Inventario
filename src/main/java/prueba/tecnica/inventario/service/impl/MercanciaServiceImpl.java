package prueba.tecnica.inventario.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import prueba.tecnica.inventario.dao.MercanciaDao;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;
import prueba.tecnica.inventario.exception.MessageNotFoundException;
import prueba.tecnica.inventario.service.MercanciaService;
import prueba.tecnica.inventario.validator.DeleteMercanciaValidator;
import prueba.tecnica.inventario.validator.FechaMercanciaValidator;
import prueba.tecnica.inventario.validator.NombreMercanciaValidator;
import prueba.tecnica.inventario.validator.UpdateMercanciaIdValidator;
import prueba.tecnica.inventario.validator.UpdateNombreMercanciaValidator;

import java.util.Date;
import java.util.List;

@Service
public class MercanciaServiceImpl implements MercanciaService {

    @Autowired
    private MercanciaDao mercanciaDao;

    @Autowired
    private NombreMercanciaValidator validatorNombre;

    @Autowired
    private FechaMercanciaValidator validatorFecha;

    @Autowired
    private UpdateMercanciaIdValidator validatorIdUpdate;

    @Autowired
    private DeleteMercanciaValidator validatorDelete;

    @Autowired
    private UpdateNombreMercanciaValidator validatorUpdateNombreMercancia;

    @Override
    public MensajeResponseDto save(MercanciaEntity mercanciaEntity) throws Exception {
        MensajeResponseDto mensajeResponse = new MensajeResponseDto();
        mensajeResponse = validatorFecha.fechaValidator(mercanciaEntity);
        if (!mensajeResponse.getStatus().equals(HttpStatus.OK)) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            mensajeResponse.setMensaje("La fecha no puede ser mayor a la actual.");
            return mensajeResponse;
        }
        mensajeResponse = validatorNombre.nombreMercanciaValidator(mercanciaEntity);
        if (!mensajeResponse.getStatus().equals(HttpStatus.OK)) {
            mensajeResponse.setMensaje("Registro fallido, se encontro un registro con esta nombre.");
            return mensajeResponse;
        }
        Date fechaActual = new Date();
        mercanciaEntity.setUsuarioUpdate(mercanciaEntity.getUsuarioRegister());
        mercanciaEntity.setFechaRegistro(fechaActual);
        mercanciaEntity.setFechaActualizacion(fechaActual);
        mercanciaDao.save(mercanciaEntity);
        mensajeResponse.setStatus(HttpStatus.CREATED);
        mensajeResponse.setMensaje("Registro exitoso.");
        return mensajeResponse;
    }

    @Override
    public MensajeResponseDto update(MercanciaEntity mercanciaEntity) throws Exception {
        MensajeResponseDto mensajeResponseDto = new MensajeResponseDto();
        MensajeResponseDto mensajeResponse = new MensajeResponseDto();
        mensajeResponse = validatorFecha.fechaValidator(mercanciaEntity);
        if (!mensajeResponse.getStatus().equals(HttpStatus.OK)) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            mensajeResponse.setMensaje("Actualizacion fallida, la fecha no puede ser mayor a la actual.");
            return mensajeResponse;
        }
        mensajeResponse = validatorUpdateNombreMercancia.updateNombreMecanciaValidator(mercanciaEntity);
        if (!mensajeResponse.getStatus().equals(HttpStatus.OK)) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            mensajeResponse.setMensaje("Actualizacion fallida, se encontro un registro con esta nombre.");
            return mensajeResponse;
        }
        mensajeResponse = validatorIdUpdate.idValidator(mercanciaEntity);
        if (!mensajeResponse.getStatus().equals(HttpStatus.OK)){
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            mensajeResponse.setMensaje("Actualizacion fallida, no se encontro mercancia con el ID: " + mercanciaEntity.getId());
            return mensajeResponse;
        }
        mercanciaDao.save(mercanciaEntity);
        mensajeResponse.setStatus(HttpStatus.OK);
        mensajeResponse.setMensaje("Actualizacion satisfactoria.");
        return mensajeResponse;

    }

    @Override
    public MensajeResponseDto delete(Long id, Long idUsuarioRegister) {
        MensajeResponseDto deleteValidatorResponse = validatorDelete.deleteValidator(id, idUsuarioRegister);
        if (deleteValidatorResponse.getStatus().equals(HttpStatus.OK)) {
            mercanciaDao.deleteById(id);
        }
        return deleteValidatorResponse;

    }

    @Override
    public List<MercanciaEntity> getAll() {
        return mercanciaDao.findAll();
    }

    @Override
    public MercanciaEntity getFindByNombre(String nombre) {
        return mercanciaDao.findByNombre(nombre)
                .orElseThrow(() -> new MessageNotFoundException("La mercancia con nombre:" + nombre + ", no se encuentra registrada"));
    }

    @Override
    public MercanciaEntity getFindById(Long id) {
        return mercanciaDao.findById(id).orElseThrow(() -> new MessageNotFoundException("La mercancia con id: " + id + " no se encuentra registrada"));
    }

}
