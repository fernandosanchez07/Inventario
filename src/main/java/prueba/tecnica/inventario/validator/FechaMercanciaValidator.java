package prueba.tecnica.inventario.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;

import java.util.Date;

@Component
public class FechaMercanciaValidator {

    public MensajeResponseDto fechaValidator(MercanciaEntity mercanciaEntity) {
        MensajeResponseDto mensajeResponseDto = new MensajeResponseDto();
        Date date = new Date();
        if (mercanciaEntity.getFechaRegistro().after(date)) {
            mensajeResponseDto.setStatus(HttpStatus.BAD_REQUEST);
            mensajeResponseDto.setMensaje("La fecha no puede ser mayor a la actual: " + mercanciaEntity.getFechaRegistro());
            return mensajeResponseDto;
        }
        mensajeResponseDto.setStatus(HttpStatus.OK);
        mensajeResponseDto.setMensaje("");
        return mensajeResponseDto;
    }
}
