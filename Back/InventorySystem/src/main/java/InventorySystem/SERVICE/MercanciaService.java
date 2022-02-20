package InventorySystem.SERVICE;

import InventorySystem.DTO.MercanciaDTO;
import java.util.List;

public interface MercanciaService {
    //CRUD - Create, Read, Update, Delete
    public List<MercanciaDTO> listarMercancias();
    public List<MercanciaDTO> listarPorUsuario(Long idUsuario);
    public void guardar(MercanciaDTO mercancia);
    public void eliminar(MercanciaDTO mercancia);
}
