package com.app.privatejet.servicios;

import com.app.privatejet.dtos.PrivateJetDTO;

import java.util.List;
import java.util.Optional;

public interface IPrivateJetService {

    public PrivateJetDTO addPrivateJet(PrivateJetDTO privateJetDTO);
    public List<PrivateJetDTO> getPrivateJets();
    public Optional<PrivateJetDTO> getPrivateJetById(String id);
    public void deleteById(String id);
}
