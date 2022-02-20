package InventorySystem.DAO;

import InventorySystem.DTO.MercanciaDTO;
import org.springframework.data.repository.CrudRepository;

public interface MercanciaDAO extends CrudRepository<MercanciaDTO, Long>{
    
}
