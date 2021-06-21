package prueba.tecnica.inventario.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import prueba.tecnica.inventario.dao.MercanciaDao;
import prueba.tecnica.inventario.dto.MensajeResponseDto;
import prueba.tecnica.inventario.entity.MercanciaEntity;
import prueba.tecnica.inventario.exception.MessageNotFoundException;

@Component
public class DeleteMercanciaValidator {

    @Autowired
    private MercanciaDao mercanciaDao;

    public MensajeResponseDto deleteValidator(Long id, Long idUsuarioRegister) {
        MensajeResponseDto deleteValidatorResponse = new MensajeResponseDto();
        try {
            MercanciaEntity mercanciaEntity = mercanciaDao.findById(id)
                    .orElseThrow(() -> new MessageNotFoundException("No se encontro la mercancia con ID: " + id));
            if (mercanciaEntity != null && !mercanciaEntity.getUsuarioRegister().getId().equals(idUsuarioRegister)) {
                deleteValidatorResponse.setStatus(HttpStatus.BAD_REQUEST);
                deleteValidatorResponse.setMensaje("El usuario con ID: " + idUsuarioRegister + ", no puede eliminar esta mercancia.");
                return deleteValidatorResponse;
            }
            else if (mercanciaEntity != null && mercanciaEntity.getUsuarioRegister().getId().equals(idUsuarioRegister)) {
                deleteValidatorResponse.setStatus(HttpStatus.OK);
                deleteValidatorResponse.setMensaje("Mercancia eliminada satisfactoriamente.");
                return deleteValidatorResponse;
            }
        }
        catch (Throwable th) {
            deleteValidatorResponse.setStatus(HttpStatus.BAD_REQUEST);
            deleteValidatorResponse.setMensaje(th.getMessage());
            return deleteValidatorResponse;
        }
        deleteValidatorResponse.setStatus(HttpStatus.BAD_REQUEST);
        deleteValidatorResponse.setMensaje("Se presento un error al momento de eliminar el producto.");
        return deleteValidatorResponse;
    }
}
