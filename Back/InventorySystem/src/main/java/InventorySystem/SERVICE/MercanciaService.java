package InventorySystem.SERVICE;

import InventorySystem.DTO.MercanciaDTO;
import java.util.List;

public interface MercanciaService {
    //CRUD - Create, Read, Update, Delete
    public List<MercanciaDTO> listarMercancias();
    public List<MercanciaDTO> listarPorUsuario(int idUsuario);
    public MercanciaDTO guardar(MercanciaDTO mercancia);
    public void eliminar(MercanciaDTO mercancia);
}
