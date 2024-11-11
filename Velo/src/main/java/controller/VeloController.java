package controller;
import dto.VeloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.Interface.IVeloService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/velo")
public class VeloController {

    @Autowired
    private IVeloService veloService;

    @PostMapping("/add")
    public VeloDto ajouterVelo(@RequestBody VeloDto veloDto) {
        return veloService.ajouterVelo(veloDto);
    }

    @GetMapping("/all")
    public List<VeloDto> afficherVelos() {
        return veloService.afficherVelos();
    }

    @GetMapping("/velo/{id}")
    public VeloDto afficherVeloParId(@PathVariable("id") long id) {
        return veloService.afficherVeloParId(id);
    }

    @PutMapping("/update/{id}")
    public VeloDto modifierVelo(@RequestBody VeloDto veloDto, @PathVariable("id") long id) {
        return veloService.updateVelo(veloDto, id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerVelo(@PathVariable("id") long id) {
        veloService.deleteVelo(id);
    }
}
