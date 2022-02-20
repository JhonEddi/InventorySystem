package InventorySystem.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Long idUsuario;
    @Column(name = "n_nombre", nullable = false, length = 25)
    private String nombre;
    @Column(name = "n_apellido", nullable = false, length = 25)
    private String apellido;
    @Column(name = "a_edad")
    private int edad;
    
    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private CargoDTO cargo;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "f_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fIngreso;
}
