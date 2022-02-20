package InventorySystem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "mercancia")
public class MercanciaDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_mercancia")
    private String idMercancia;
    @Column(name = "q_cantidad", nullable = false)
    private int cantidad;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "f_creacion", nullable = false)
    private Date fCreacion;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioDTO usuario ;
}
