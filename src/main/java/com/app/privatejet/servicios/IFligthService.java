package com.app.privatejet.servicios;

import com.app.privatejet.dtos.FligthDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IFligthService {

    public FligthDTO addFligth(@Valid FligthDTO fligthDTO);
    public List<FligthDTO> getFligths();
    public Optional<FligthDTO> getFligthById(String id);
    public FligthDTO updateFligth(String id, FligthDTO fligthDTO);
    public void deleteFligthById(String id);



}
