package prueba.tecnica.inventario.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dao.MercanciaDao;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

@Component
public class UpdateMercanciaIdValidator {

    @Autowired
    private MercanciaDao mercanciaDao;

    public MensajeResponseDto idValidator(MercanciaEntity mercanciaEntity) {
        MensajeResponseDto mensajeResponse = new MensajeResponseDto();
        if (!mercanciaDao.findById(mercanciaEntity.getId()).isPresent()) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            return mensajeResponse;
        }
        mensajeResponse.setStatus(HttpStatus.OK);
        return mensajeResponse;
    }
}