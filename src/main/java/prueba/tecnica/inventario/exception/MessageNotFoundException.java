package prueba.tecnica.inventario.exception;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String mensaje) {
        super(mensaje);
    }
}
