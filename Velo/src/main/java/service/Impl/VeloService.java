package service.Impl;

import dto.VeloDto;
import entity.Velo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VeloRepository;
import service.Interface.IVeloService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeloService implements IVeloService {

    @Autowired
    VeloRepository veloRepository;

    // Convert Velo entity to VeloDto
    private VeloDto convertEntityToDto(Velo velo) {
        return new VeloDto(velo.getId(), velo.getType(), velo.getMarque(), velo.isStatus());
    }

    // Convert VeloDto to Velo entity
    private Velo convertDtoToEntity(VeloDto veloDto) {
        Velo velo = new Velo();
        velo.setId(veloDto.getId());
        velo.setType(veloDto.getType());
        velo.setMarque(veloDto.getMarque());
        velo.setStatus(veloDto.isStatus());
        return velo;
    }

    @Override
    public VeloDto ajouterVelo(VeloDto veloDto) {
        Velo velo = convertDtoToEntity(veloDto);
        Velo savedVelo = veloRepository.save(velo);
        return convertEntityToDto(savedVelo);
    }

    @Override
    public List<VeloDto> afficherVelos() {
        List<Velo> velos = veloRepository.findAll();
        return velos.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    @Override
    public VeloDto afficherVeloParId(long id) {
        Optional<Velo> velo = veloRepository.findById(id);
        return velo.map(this::convertEntityToDto).orElse(null); // Return null if not found
    }

    @Override
    public VeloDto updateVelo(VeloDto veloDto, long id) {
        Optional<Velo> veloOpt = veloRepository.findById(id);
        if (veloOpt.isPresent()) {
            Velo existingVelo = veloOpt.get();
            existingVelo.setType(veloDto.getType());
            existingVelo.setMarque(veloDto.getMarque());
            existingVelo.setStatus(veloDto.isStatus());
            Velo updatedVelo = veloRepository.save(existingVelo);
            return convertEntityToDto(updatedVelo);
        } else {
            return null; // Handle not found case
        }
    }

    @Override
    public void deleteVelo(long id) {
        veloRepository.deleteById(id);
    }
}