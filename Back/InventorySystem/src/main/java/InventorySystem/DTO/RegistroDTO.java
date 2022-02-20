package InventorySystem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "registro")
@IdClass(RegistroDTO.class)
public class RegistroDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioDTO usuario;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_mercancia", nullable = false)
    private MercanciaDTO mercancia;
    
    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "f_modificacion", nullable = false)
    private Date fModificacion;
}
