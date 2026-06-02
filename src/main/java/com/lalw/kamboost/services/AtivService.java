package com.lalw.kamboost.services;

import com.lalw.kamboost.models.AtivModel;
import com.lalw.kamboost.repositorys.AtivRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AtivService {
    @Autowired
    private AtivRepository ativRepository;

    public List<AtivModel> listarAtividades() {
        Sort sort = Sort.by("nomeAtiv").descending();
        return ativRepository.findAll(sort);
    }

    public AtivModel adicionarAtividade(AtivModel ativModel){
        return ativRepository.save(ativModel);
    }

    public void deletarAtividade(Integer id){
        if(ativRepository.existsById(id)) {
            ativRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }


}

