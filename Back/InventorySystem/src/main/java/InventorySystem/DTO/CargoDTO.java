package InventorySystem.DTO;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cargo")
public class CargoDTO implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCargo;
    @Column(name = "d_descripcion", nullable = false)
    private String descripcion;
}
