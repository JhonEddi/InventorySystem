package InventorySystem.IMPLEMENT;

import InventorySystem.DAO.MercanciaDAO;
import InventorySystem.DTO.MercanciaDTO;
import InventorySystem.SERVICE.MercanciaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MercanciaImplement implements MercanciaService{
    
    @Autowired
    private MercanciaDAO mercanciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<MercanciaDTO> listarMercancias() {
        return (List<MercanciaDTO>) mercanciaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<MercanciaDTO> listarPorUsuario(int idUsuario) {
        List<MercanciaDTO> mercanciasRespuesta = new ArrayList<>();
        List<MercanciaDTO> mercancias = (List<MercanciaDTO>) mercanciaDao.findAll();
        for (int i = 0; i < mercancias.size(); i++) {
            if (mercancias.get(i).getUsuario().getIdUsuario()==idUsuario) {
                mercanciasRespuesta.add(mercancias.get(i));
            }
        }
        return mercanciasRespuesta;
    }

    @Override
    @Transactional
    public MercanciaDTO guardar(MercanciaDTO mercancia) {
        return mercanciaDao.save(mercancia);
    }

    @Override
    @Transactional
    public void eliminar(MercanciaDTO mercancia) {
        mercanciaDao.delete(mercancia);
    }
}
