package com.app.privatejet.servicios;

import com.app.privatejet.dtos.CelebrityDTO;
import com.app.privatejet.modelos.Celebrity;
import com.app.privatejet.repositorios.ICelebrityRepositoy;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Validated
public class CelebrityService implements ICelebrityService{

    @Autowired
    private ICelebrityRepositoy celebrityRepository;

    @Override
    public CelebrityDTO addCelebrity(@Valid CelebrityDTO celebrityDTO) {

        Celebrity celebrity = new Celebrity();
        celebrity.setName(celebrityDTO.getName());
        celebrity.setProfession(celebrityDTO.getProfession());
        celebrity.setNet_worth(celebrityDTO.getNet_worth());
        celebrity.setSuspicious_activity(celebrity.isSuspicious_activity());

        celebrity = celebrityRepository.save(celebrity);

        return convertirADTO(celebrity);
    }

    @Override
    public List<CelebrityDTO> getCelebrities() {
        return celebrityRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CelebrityDTO> getCelebrityById(String Id) {

        if(!celebrityRepository.existsById(Id)){
            throw new EntityNotFoundException("celebrity with ID" + Id + "Not found");
        }

        return celebrityRepository.findById(Id).map(this::convertirADTO);
    }

    @Override
    public Optional<CelebrityDTO> getCelebrityByName(String Name) {

        if(!celebrityRepository.existsByName(Name)){
            throw new EntityNotFoundException("celebrity with name" + Name + "Not found");
        }
        return celebrityRepository.findByName(Name).map(this::convertirADTO);
    }

    @Override
    public void deleteCelebrityById(String id) {

        if(!celebrityRepository.existsById(id)){
            throw new EntityNotFoundException("celebrity with ID" + id + "Not found");
        }

        celebrityRepository.deleteById(id);
    }

    public CelebrityDTO convertirADTO(Celebrity celebrity){
        return new CelebrityDTO(
                celebrity.getId(),
                celebrity.getName(),
                celebrity.getProfession(),
                celebrity.getNet_worth(),
                celebrity.isSuspicious_activity()
        );
    }
}
