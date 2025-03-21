package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.Fligth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IFligthRepository extends JpaRepository<Fligth, String> {

    public Fligth save(Fligth fligth);
    public Optional<Fligth> findById(String id);
    public List<Fligth> findAll();
    public void deleteById(String id);
    public Fligth findByName(String name);
}
