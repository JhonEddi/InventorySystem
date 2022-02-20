package InventorySystem.DAO;

import InventorySystem.DTO.RegistroDTO;
import org.springframework.data.repository.CrudRepository;

public interface RegistroDAO extends CrudRepository<RegistroDTO, Long>{
    
}
