package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.PrivateJetDTO;
import com.app.privatejet.servicios.IPrivateJetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/privateJet")
public class PrivateJetController {

    @Autowired
    private IPrivateJetService privateJetService;

    @GetMapping("/")
    public ResponseEntity<List<PrivateJetDTO>> getPrivateJets(){

        return ResponseEntity.ok(privateJetService.getPrivateJets());
    }

    @PostMapping("/")
    public ResponseEntity<PrivateJetDTO> createPrivateJet(@Valid @RequestBody PrivateJetDTO privateJetDTO) {

        PrivateJetDTO newPrivateJet = privateJetService.addPrivateJet(privateJetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPrivateJet);
    }

    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<PrivateJetDTO>> findPrivateJetById(@PathVariable String id){
        return ResponseEntity.ok(privateJetService.getPrivateJetById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrivateJet(@PathVariable String id){
        privateJetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
