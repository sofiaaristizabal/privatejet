package com.app.privatejet.servicios;

import com.app.privatejet.dtos.PrivateJetDTO;
import com.app.privatejet.modelos.PrivateJet;
import com.app.privatejet.repositorios.ICelebrityRepositoy;
import com.app.privatejet.repositorios.IPivateJetRepository;
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
public class PrivateJetService implements IPrivateJetService{

    @Autowired
    private IPivateJetRepository pivateJetRepository;

    @Autowired
    private ICelebrityRepositoy celebrityRepositoy;

    @Override
    @CacheEvict(value = {"privateJets", "privateJet"}, allEntries = true)
    public PrivateJetDTO addPrivateJet(@Valid PrivateJetDTO privateJetDTO) {

        PrivateJet privateJet = new PrivateJet();
        privateJet.setModel(privateJetDTO.getModel());
        privateJet.setCapacity(privateJetDTO.getCapacity());
        privateJet.setCelebrity(
                celebrityRepositoy.findById(privateJetDTO.getCelebrity_id()).orElseThrow(() -> new EntityNotFoundException("Celebrity not found with id: " + privateJetDTO.getCelebrity_id()))
        );

        privateJet = pivateJetRepository.save(privateJet);

        return convertirADTO(privateJet);
    }

    @Override
    @Cacheable(value = "privateJets")
    public List<PrivateJetDTO> getPrivateJets() {

        return pivateJetRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    @Cacheable(value = "privateJet", key = "#id")
    public Optional<PrivateJetDTO> getPrivateJetById(String id) {

        if(!pivateJetRepository.existsById(id)){
            throw new EntityNotFoundException("Private jet with id" + id + "not found");
        }

        return pivateJetRepository.findById(id).map(this::convertirADTO);
    }

    @Override
    @CachePut(value="privateJet", key="#id")
    @CacheEvict(value = "privateJets", allEntries = true)
    public PrivateJetDTO updatePrivateJet(String id, PrivateJetDTO privateJetDTO) {
        return pivateJetRepository.findById(id).map(
                privateJet -> {
                    privateJet.setModel(privateJetDTO.getModel());
                    privateJet.setCapacity(privateJetDTO.getCapacity());
                    privateJet.setCelebrity(celebrityRepositoy.findById(privateJetDTO.getCelebrity_id()).orElseThrow(() -> new EntityNotFoundException("Celebrity not found with id: " + privateJetDTO.getCelebrity_id())));

                    return convertirADTO(pivateJetRepository.save(privateJet));
                }
        ).orElseThrow(() -> new RuntimeException("private Jet not found"));
    }

    @Override
    @CacheEvict(value = {"privateJet", "privateJets"}, key = "#id", allEntries = true)
    public void deleteById(String id) {

        if(!pivateJetRepository.existsById(id)){
            throw new EntityNotFoundException("Private jet with id" + id + "not found");
        }

         pivateJetRepository.deleteById(id);
    }


    private PrivateJetDTO convertirADTO(PrivateJet privateJet){

        return new PrivateJetDTO(
                privateJet.getId(),
                privateJet.getModel(),
                privateJet.getCapacity(),
                privateJet.getCelebrity().getId()
        );
    }
}
