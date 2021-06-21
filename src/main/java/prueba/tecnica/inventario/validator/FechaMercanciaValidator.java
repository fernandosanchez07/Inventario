package prueba.tecnica.inventario.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

import java.util.Date;

@Component
public class FechaMercanciaValidator {

    public MensajeResponseDto fechaValidator(MercanciaEntity mercanciaEntity) {
        MensajeResponseDto deleteValidatorResponse = new MensajeResponseDto();
        Date date = new Date();
        if (mercanciaEntity.getFechaRegistro().after(date)) {
            deleteValidatorResponse.setStatus(HttpStatus.BAD_REQUEST);
            deleteValidatorResponse.setMensaje("La fecha no puede ser mayor a la actual: " + mercanciaEntity.getFechaRegistro());
            return deleteValidatorResponse;
        }
        deleteValidatorResponse.setStatus(HttpStatus.OK);
        deleteValidatorResponse.setMensaje("");
        return deleteValidatorResponse;
    }
}
