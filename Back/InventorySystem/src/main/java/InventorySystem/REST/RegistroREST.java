package InventorySystem.REST;

import InventorySystem.DTO.RegistroDTO;
import InventorySystem.SERVICE.RegistroService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/registro/")
public class RegistroREST {
    
    @Autowired
    private RegistroService registroService;
    
    @GetMapping
    private ResponseEntity<List<RegistroDTO>> getAllRegistros(){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarRegistros());
    }
    
    private ResponseEntity<List<RegistroDTO>> getAllRegistrosByUsuario(@PathVariable("idCargo") Long idUsuario){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarPorUsuario(idUsuario));
    }
    
    private ResponseEntity<List<RegistroDTO>> getAllRegistrosByMercancia(@PathVariable("idCargo") String idMercancia){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarPorMercancia(idMercancia));
    }
}
