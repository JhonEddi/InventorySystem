package InventorySystem.SERVICE;

import InventorySystem.DTO.CargoDTO;
import java.util.List;

public interface CargoService {
    //CRUD - Create, Read, Update, Delete
    public List<CargoDTO> listarCargos();
    public void guardar(CargoDTO cargo);
    public void eliminar(CargoDTO cargo);
}
