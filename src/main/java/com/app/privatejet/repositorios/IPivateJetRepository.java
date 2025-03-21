package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.PrivateJet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IPivateJetRepository extends JpaRepository<PrivateJet, String> {

    public PrivateJet save(PrivateJet privateJet);
    public Optional<PrivateJet> findByIs(String id);
    public List<PrivateJet> findAll();
    public void deleteById(String id);

    public PrivateJet findByName(String name);
}
