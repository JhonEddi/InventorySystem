package InventorySystem.IMPLEMENT;

import InventorySystem.DAO.RegistroDAO;
import InventorySystem.DTO.RegistroDTO;
import InventorySystem.SERVICE.RegistroService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistroImplement implements RegistroService{

    @Autowired
    private RegistroDAO registroDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> listarRegistros() {
        return (List<RegistroDTO>) registroDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> listarPorUsuario(int idUsuario) {
        List<RegistroDTO> registrosRespuesta = new ArrayList<>();
        List<RegistroDTO> registros = (List<RegistroDTO>) registroDao.findAll();
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getUsuario().getIdUsuario()==idUsuario) {
                registrosRespuesta.add(registros.get(i));
            }
        }
        return registrosRespuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RegistroDTO> listarPorMercancia(String idMercancia) {
        List<RegistroDTO> registrosRespuesta = new ArrayList<>();
        List<RegistroDTO> registros = (List<RegistroDTO>) registroDao.findAll();
        for (int i = 0; i < registros.size(); i++) {
            if (registros.get(i).getMercancia().getIdMercancia()==idMercancia) {
                registrosRespuesta.add(registros.get(i));
            }
        }
        return registrosRespuesta;
    }

    @Override
    @Transactional
    public RegistroDTO guardar(RegistroDTO registro) {
        return registroDao.save(registro);
    }
    
}
