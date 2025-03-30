package com.app.privatejet.servicios;

import com.app.privatejet.dtos.PrivateJetDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IPrivateJetService {

    public PrivateJetDTO addPrivateJet(@Valid PrivateJetDTO privateJetDTO);
    public List<PrivateJetDTO> getPrivateJets();
    public Optional<PrivateJetDTO> getPrivateJetById(String id);
    public PrivateJetDTO updatePrivateJet(String id, PrivateJetDTO privateJetDTO);
    public void deleteById(String id);
}
