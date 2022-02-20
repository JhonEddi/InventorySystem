package InventorySystem.SERVICE;

import InventorySystem.DTO.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    //CRUD - Create, Read, Update, Delete
    public List<UsuarioDTO> listarUsuarios();
    public List<UsuarioDTO> listarPorCargo(Long idCargo);
//    public void guardar(UsuarioDTO usuario);
//    public void eliminar(UsuarioDTO usuario);
//    public UsuarioDTO encontrarUsuario(UsuarioDTO usuario);
}
