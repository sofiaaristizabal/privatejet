package com.app.privatejet.servicios;

import com.app.privatejet.dtos.FligthDTO;
import com.app.privatejet.modelos.Fligth;
import com.app.privatejet.repositorios.ICelebrityRepositoy;
import com.app.privatejet.repositorios.IFligthRepository;
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
public class FligthService implements IFligthService{

    @Autowired
    private IFligthRepository fligthRepository;

    @Autowired
    private ICelebrityRepositoy celebrityRepositoy;

    @Autowired
    private IPivateJetRepository pivateJetRepository;

    @Override
    public FligthDTO addFligth(@Valid FligthDTO fligthDTO) {

        Fligth  fligth = new Fligth();
        fligth.setDeparture_time(fligthDTO.getDeparture_time());
        fligth.setArrival_time(fligthDTO.getArrival_time());
        fligth.setPurpose(fligthDTO.getPurpose());
        fligth.setCelebrity(
                celebrityRepositoy.findById(fligthDTO.getCelebrity_id())
                        .orElseThrow(() -> new EntityNotFoundException("Celebrity not found with id: " + fligthDTO.getCelebrity_id()))
        );
        fligth.setPrivateJet(
                pivateJetRepository.findById(fligthDTO.getPrivateJet_id()).orElseThrow(() -> new EntityNotFoundException("Celebrity not found with id: " + fligthDTO.getCelebrity_id()))
        );

        fligth = fligthRepository.save(fligth);

        return convertirADTO(fligth);
    }

    @Override
    public List<FligthDTO> getFligths() {
        return fligthRepository.findAll().stream().map(this::convertirADTO).collect(Collectors.toList());
    }

    @Override
    public Optional<FligthDTO> getFligthById(String id) {

        if(!fligthRepository.existsById(id)){
            throw new EntityNotFoundException("Fligth with Id" + id + "not found");
        }
        return fligthRepository.findById(id).map(this::convertirADTO);
    }

    @Override
    public void deleteFligthById(String id) {

        if(!fligthRepository.existsById(id)){
            throw new EntityNotFoundException("Fligth with Id" + id + "not found");
        }

        fligthRepository.deleteById(id);
    }

    private FligthDTO convertirADTO(Fligth fligth){

        return new FligthDTO(
                fligth.getId(),
                fligth.getDeparture_time(),
                fligth.getArrival_time(),
                fligth.getPurpose(),
                fligth.getCelebrity().getId(),
                fligth.getPrivateJet().getId()
        );
    }
}
