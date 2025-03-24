package com.app.privatejet.servicios;

import com.app.privatejet.dtos.CelebrityDTO;

import java.util.List;
import java.util.Optional;

public interface ICelebrityService {

    public CelebrityDTO addCelebrity(CelebrityDTO celebrityDTO);
    public List<CelebrityDTO> getCelebrities();
    public Optional<CelebrityDTO> getCelebrityById( String Id);
    public Optional<CelebrityDTO> getCelebrityByName (String Name);
    public void deleteCelebrityById (String id);


}
