package com.app.privatejet.repositorios;

import com.app.privatejet.modelos.Celebrity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICelebrityRepositoy extends JpaRepository <Celebrity, String> {

    public Celebrity save(Celebrity celebrity);
    public Optional<Celebrity> findById(String id);
    public List<Celebrity> findAll();
    public void deleteById(String id);

    public Celebrity findByName(String name);
}
