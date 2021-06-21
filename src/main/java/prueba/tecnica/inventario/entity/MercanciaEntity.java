package prueba.tecnica.inventario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "mercancia")
public class MercanciaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;

    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date fechaRegistro;

    @Column(name = "fecha_update")
    @Temporal(TemporalType.DATE)
    private Date fechaActualizacion;

    @ManyToOne
    @JoinColumn(name="id_usuario_register", updatable = false)
    private UsuarioEntity usuarioRegister;

    @ManyToOne
    @JoinColumn(name="id_usuario_update")
    private UsuarioEntity usuarioUpdate;
}
