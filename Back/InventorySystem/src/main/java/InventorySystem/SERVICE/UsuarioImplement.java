package InventorySystem.SERVICE;

import InventorySystem.DAO.UsuarioDAO;
import InventorySystem.DTO.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioImplement implements UsuarioService{
    
    @Autowired
    private UsuarioDAO usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarUsuarios() {
        return (List<UsuarioDTO>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> listarPorCargo(Long idCargo) {
        List<UsuarioDTO> usuariosRespuesta = new ArrayList<>();
        List<UsuarioDTO> usuarios = (List<UsuarioDTO>) usuarioDao.findAll();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getCargo().getIdCargo()==idCargo) {
                usuariosRespuesta.add(usuarios.get(i));
            }
        }
        return usuariosRespuesta;
    }

//    @Override
//    @Transactional
//    public void guardar(UsuarioDTO usuario) {
//        usuarioDao.save(usuario);
//    }
//
//    @Override
//    @Transactional
//    public void eliminar(UsuarioDTO usuario) {
//        usuarioDao.delete(usuario);
//    }

//    @Override
//    @Transactional(readOnly = true)
//    public UsuarioDTO encontrarUsuario(UsuarioDTO usuario) {
//        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
//    }

}
