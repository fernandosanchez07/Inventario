package prueba.tecnica.inventario.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dao.MercanciaDao;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

@Component
public class NombreMercanciaValidator {

    @Autowired
    private MercanciaDao mercanciaDao;

    public MensajeResponseDto nombreMercanciaValidator(MercanciaEntity mercanciaEntity) {
        MensajeResponseDto mensajeResponse = new MensajeResponseDto();
        if (mercanciaDao.findByNombre(mercanciaEntity.getNombre()).isPresent()) {
            mensajeResponse.setStatus(HttpStatus.BAD_REQUEST);
            return mensajeResponse;
        }else{
        mensajeResponse.setStatus(HttpStatus.OK);
        return mensajeResponse;
        }
    }
}
