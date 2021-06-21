package prueba.tecnica.inventario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MensajeResponseDto {

    private HttpStatus status;
    private String mensaje;

}
