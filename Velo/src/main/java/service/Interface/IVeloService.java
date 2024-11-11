package service.Interface;

import dto.VeloDto;

import java.util.List;

public interface IVeloService {
    VeloDto ajouterVelo(VeloDto velo);
    List<VeloDto> afficherVelos();
    VeloDto afficherVeloParId(long id);
    VeloDto updateVelo(VeloDto velodto, long id);  // Changed return type to VeloDto
    void deleteVelo(long id);
}
