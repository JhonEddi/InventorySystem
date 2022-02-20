package InventorySystem.REST;

import InventorySystem.DTO.UsuarioDTO;
import InventorySystem.SERVICE.UsuarioService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/usuario/")
public class UsuarioREST {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    private ResponseEntity<List<UsuarioDTO>> getAllUsuarios(){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
    
    @GetMapping("{idCargo}")
    private ResponseEntity<List<UsuarioDTO>> getAllUsuariosByCargo(@PathVariable("idCargo") Long idCargo){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(usuarioService.listarPorCargo(idCargo));
    }
}
