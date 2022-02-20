package InventorySystem.SERVICE;

import InventorySystem.DTO.RegistroDTO;
import java.util.List;

public interface RegistroService {
    //CRUD - Create, Read, Update, Delete
    public List<RegistroDTO> listarRegistros();
    public List<RegistroDTO> listarPorUsuario(Long idUsuario);
    public List<RegistroDTO> listarPorMercancia(String idMercancia);
    public void guardar(RegistroDTO registro);
}
