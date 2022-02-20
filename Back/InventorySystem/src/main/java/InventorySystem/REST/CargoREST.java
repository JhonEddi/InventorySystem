package InventorySystem.REST;

import InventorySystem.DTO.CargoDTO;
import InventorySystem.SERVICE.CargoService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("/cargo/")
public class CargoREST {

    @Autowired
    private CargoService cargoService;
    
    @GetMapping
//    public String inicio(Model model) {
//        var cargos = cargoService.listarCargos();
//        log.info("Funciona!!!!!!!");
//        model.addAttribute("cargos", cargos);
//        return "IndexCargo";
//    }
    private ResponseEntity<List<CargoDTO>> getAllCargos(){
        log.info("Ejecutando controlador Spring MVC");
        return ResponseEntity.ok(cargoService.listarCargos());
    }
}
