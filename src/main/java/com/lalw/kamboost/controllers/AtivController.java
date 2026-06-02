package com.lalw.kamboost.controllers;

import com.lalw.kamboost.models.AtivModel;
import com.lalw.kamboost.repositorys.AtivRepository;
import com.lalw.kamboost.services.AtivService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atividades")
@CrossOrigin(origins = "*")
public class AtivController {
    @Autowired
    private AtivService ativService;

    @GetMapping
    public ResponseEntity<List<AtivModel>> listarAtividades(){
        return ResponseEntity.ok(ativService.listarAtividades());
    }

    @PostMapping("/novaAtividade")
    public ResponseEntity<AtivModel> adicionarAtividade(@RequestBody AtivModel ativModel){
        return ResponseEntity.ok(ativService.adicionarAtividade(ativModel));
    }

    @DeleteMapping("/delAtiv/{id}")
    public void deletarAtividade(@PathVariable Integer id){
        ativService.deletarAtividade(id);
    }
}
