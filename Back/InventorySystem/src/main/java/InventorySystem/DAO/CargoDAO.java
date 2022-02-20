package InventorySystem.DAO;

import InventorySystem.DTO.CargoDTO;
import org.springframework.data.repository.CrudRepository;

public interface CargoDAO extends CrudRepository<CargoDTO, Long>{
    
}
