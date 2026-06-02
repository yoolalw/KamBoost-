package com.lalw.kamboost.controllers;

import com.lalw.kamboost.models.UserModel;
import com.lalw.kamboost.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserModel>> listarUser(){
        return ResponseEntity.ok(userService.listarUser());
    }

    @PostMapping("/novoUser")
    public ResponseEntity<List<UserModel>> novoUser(@RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.novoUser(userModel));
    }

    @PutMapping("/attUser/{id}")
    public ResponseEntity<UserModel> userAtualizado(@PathVariable Integer id, @RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.userAtualizado(id, userModel));
    }

    @DeleteMapping("/delUser/{id}")
    public void deletarUser(@PathVariable Integer id){
        userService.deletarUsuario(id);
    }

}
