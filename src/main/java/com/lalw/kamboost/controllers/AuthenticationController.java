package com.lalw.kamboost.controllers;

import com.lalw.kamboost.dto.AuthenticationDto;
import com.lalw.kamboost.dto.RegisterDto;
import com.lalw.kamboost.models.UserModel;
import com.lalw.kamboost.models.UserRole;
import com.lalw.kamboost.repositorys.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDto data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.emailUser(), data.senhaUser());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }
    @PostMapping("/novoUser")
    public ResponseEntity<List<UserModel>> novoUser(@RequestBody @Valid RegisterDto data){
        if(this.repository.findByEmailUser(data.emailUser()) != null) return ResponseEntity.badRequest().build();
        String encryptPass = new BCryptPasswordEncoder().encode(data.senhaUser());
        UserModel user = new UserModel(data.nomeUser(), data.emailUser(), encryptPass, data.role());
        return ResponseEntity.ok().build();
    }

}
