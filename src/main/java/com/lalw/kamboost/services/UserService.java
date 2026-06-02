package com.lalw.kamboost.services;

import com.lalw.kamboost.models.UserModel;
import com.lalw.kamboost.repositorys.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserModel> listarUser() {
        Sort sort = Sort.by("nomeUser").ascending();
        return userRepository.findAll(sort);
    }

    public List<UserModel> novoUser(UserModel userModel) {
        if (!userRepository.existsByEmailUser(userModel.getEmailUser())) {
            userRepository.save(userModel);
        }
        return listarUser();
    }

    public UserModel userAtualizado(Integer id, UserModel userAtt) {
        UserModel exist = userRepository.findById(id).orElseThrow(NoSuchElementException::new);
        exist.setEmailUser(userAtt.getEmailUser());
        exist.setNomeUser(userAtt.getSenhaUser());
        exist.setSenhaUser(userAtt.getNomeUser());
        return userRepository.save(exist);
    }

    public void deletarUsuario(Integer id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }


}
