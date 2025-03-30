package com.app.privatejet.servicios;

import com.app.privatejet.dtos.CelebrityDTO;
import com.app.privatejet.modelos.Celebrity;
import com.app.privatejet.repositorios.ICelebrityRepositoy;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = {"celebrities", "celebrity"}, allEntries = true)
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
    @Cacheable(value = "celebrities")
    public List<CelebrityDTO> getCelebrities() {
        return celebrityRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "celebrity", key = "#Id")
    public Optional<CelebrityDTO> getCelebrityById(String Id) {

        if(!celebrityRepository.existsById(Id)){
            throw new EntityNotFoundException("celebrity with ID" + Id + "Not found");
        }

        return celebrityRepository.findById(Id).map(this::convertirADTO);
    }

    @Override
    @Cacheable(value = "celebrity", key = "#name")
    public Optional<CelebrityDTO> getCelebrityByName(String name) {

        if(!celebrityRepository.existsByName(name)){
            throw new EntityNotFoundException("celebrity with name" + name + "Not found");
        }
        return celebrityRepository.findByName(name).map(this::convertirADTO);
    }

    @Override
    @CachePut(value="celebrity", key="#id")
    @CacheEvict(value = "celebrities", allEntries = true)
    public CelebrityDTO updateCelebrity(String id, CelebrityDTO celebrityDTO) {
        return celebrityRepository.findById(id).map(
                celebrity ->{
                    celebrity.setName(celebrityDTO.getName());
                    celebrity.setProfession(celebrityDTO.getProfession());
                    celebrity.setNet_worth(celebrityDTO.getNet_worth());
                    celebrity.setSuspicious_activity(celebrityDTO.isSuspicious_activity());

                    return convertirADTO(celebrityRepository.save(celebrity));
                }
        ).orElseThrow(() -> new RuntimeException("celebrity not found"));
    }

    @Override
    @CacheEvict(value = {"celebrity", "celebrities"}, key = "#id", allEntries = true)
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
