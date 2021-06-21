package prueba.tecnica.inventario.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dao.MercanciaDao;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

@Component
public class UpdateNombreMercanciaValidator {
    @Autowired
    private MercanciaDao mercanciaDao;

    public MensajeResponseDto updateNombreMecanciaValidator(MercanciaEntity mercanciaEntity) {
        MensajeResponseDto mensajeResponse = new MensajeResponseDto();
        Long idActualizar = mercanciaEntity.getId();
        mercanciaEntity = mercanciaDao.findByNombre(mercanciaEntity.getNombre()).orElse(null);
        if (mercanciaEntity != null && !mercanciaEntity.getId().equals(idActualizar)) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            return mensajeResponse;
        }else{
            mensajeResponse.setStatus(HttpStatus.OK);
            return mensajeResponse;
        }
    }
}
