package InventorySystem.REST;

import InventorySystem.DTO.RegistroDTO;
import InventorySystem.SERVICE.RegistroService;
import java.net.URI;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private ResponseEntity<List<RegistroDTO>> getAllRegistros() {
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarRegistros());
    }

    @GetMapping("{idUsuario}")
    private ResponseEntity<List<RegistroDTO>> getAllRegistrosByUsuario(@PathVariable("idUsuario") int idUsuario) {
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarPorUsuario(idUsuario));
    }

    @GetMapping("{idMercancia}")
    private ResponseEntity<List<RegistroDTO>> getAllRegistrosByMercancia(@PathVariable("idMercancia") String idMercancia) {
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(registroService.listarPorMercancia(idMercancia));
    }

    @PostMapping
    private ResponseEntity<RegistroDTO> saveRegistro(@RequestBody RegistroDTO registro){
        try {
            RegistroDTO registroGuardado = registroService.guardar(registro);
            return ResponseEntity.created(new URI("/registro/"+registroGuardado.getMercancia().getIdMercancia())).body(registroGuardado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
