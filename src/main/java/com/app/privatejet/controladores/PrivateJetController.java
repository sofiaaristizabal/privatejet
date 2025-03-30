package com.app.privatejet.controladores;

import com.app.privatejet.dtos.AirportDTO;
import com.app.privatejet.dtos.PrivateJetDTO;
import com.app.privatejet.servicios.IPrivateJetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/privateJet")
@Tag(name = "PrivateJet controller", description = "Manage privateJet operations" )
public class PrivateJetController {

    @Autowired
    private IPrivateJetService privateJetService;

    @GetMapping("/")
    @Operation(summary = "Get privateJets", description = "Retrieves a list of all privateJets.")
    public ResponseEntity<List<PrivateJetDTO>> getPrivateJets(){

        return ResponseEntity.ok(privateJetService.getPrivateJets());
    }

    @PostMapping("/")
    @Operation(summary = "Create a privateJet", description = "Add a new privateJet to the repository")
    public ResponseEntity<PrivateJetDTO> createPrivateJet(@Valid @RequestBody PrivateJetDTO privateJetDTO) {

        PrivateJetDTO newPrivateJet = privateJetService.addPrivateJet(privateJetDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPrivateJet);
    }

    @GetMapping("/findId/{id}")
    @Operation(summary = "find privateJet by Id", description = "find a privateJet from the repository by it's Id")
    public ResponseEntity<Optional<PrivateJetDTO>> findPrivateJetById(@PathVariable String id){
        return ResponseEntity.ok(privateJetService.getPrivateJetById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete a privateJet", description = "Delete a privateJet by it's Id from repository")
    public ResponseEntity<Void> deletePrivateJet(@PathVariable String id){
        privateJetService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
