package InventorySystem.SERVICE;

import InventorySystem.DAO.CargoDAO;
import InventorySystem.DTO.CargoDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CargoImplement implements CargoService{

    @Autowired
    private CargoDAO cargoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<CargoDTO> listarCargos() {
        return (List<CargoDTO>) cargoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(CargoDTO cargo) {
        cargoDao.save(cargo);
    }

    @Override
    @Transactional
    public void eliminar(CargoDTO cargo) {
        cargoDao.delete(cargo);
    }
    
}
