package InventorySystem.DAO;

import InventorySystem.DTO.UsuarioDTO;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDAO extends CrudRepository<UsuarioDTO, Long>{
    
}
