package com.app.privatejet.servicios;

import com.app.privatejet.dtos.PrivateJetDTO;
import com.app.privatejet.modelos.PrivateJet;
import com.app.privatejet.repositorios.IPivateJetRepository;
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
public class PrivateJetService implements IPrivateJetService{

    @Autowired
    private IPivateJetRepository pivateJetRepository;

    @Override
    public PrivateJetDTO addPrivateJet(@Valid PrivateJetDTO privateJetDTO) {

        PrivateJet privateJet = new PrivateJet();
        privateJet.setModel(privateJetDTO.getModel());
        privateJet.setCapacity(privateJetDTO.getCapacity());
        privateJet.setCelebrity(privateJetDTO.getCelebrity());

        privateJet = pivateJetRepository.save(privateJet);

        return convertirADTO(privateJet);
    }

    @Override
    public List<PrivateJetDTO> getPrivateJets() {

        return pivateJetRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<PrivateJetDTO> getPrivateJetById(String id) {

        if(!pivateJetRepository.existsById(id)){
            throw new EntityNotFoundException("Private jet with id" + id + "not found");
        }

        return pivateJetRepository.findById(id).map(this::convertirADTO);
    }

    @Override
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
                privateJet.getCelebrity()
        );
    }
}
