package com.app.privatejet.servicios;

import com.app.privatejet.dtos.FligthDTO;
import java.util.List;
import java.util.Optional;

public interface IFligthService {

    public FligthDTO addFligth(FligthDTO fligthDTO);
    public List<FligthDTO> getFligths();
    public Optional<FligthDTO> getFligthById(String id);
    public Optional<FligthDTO> getFligthByName(String Name);
    public void deleteFligthById(String id);



}
