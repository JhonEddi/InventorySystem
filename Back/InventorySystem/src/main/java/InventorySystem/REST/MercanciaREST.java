package InventorySystem.REST;

import InventorySystem.DTO.MercanciaDTO;
import InventorySystem.SERVICE.MercanciaService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/mercancia/")
public class MercanciaREST {
    
    @Autowired
    private MercanciaService mercanciaService;
    
    @GetMapping
    private ResponseEntity<List<MercanciaDTO>> getAllMercancias(){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(mercanciaService.listarMercancias());
    }
    
    @GetMapping("{idUsuario}")
    private ResponseEntity<List<MercanciaDTO>> getAllMercanciasByUsuario(@PathVariable("idUsuario") Long idUsuario){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(mercanciaService.listarPorUsuario(idUsuario));
    }
    
    @PostMapping
    private ResponseEntity<MercanciaDTO> saveMercancia(@RequestBody MercanciaDTO mercancia){
        try {
            MercanciaDTO mercanciaGuardada = mercanciaService.guardar(mercancia);
            return ResponseEntity.created(new URI("/mercancia/"+mercanciaGuardada.getIdMercancia())).body(mercanciaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
