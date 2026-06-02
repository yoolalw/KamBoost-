package com.lalw.kamboost.repositorys;

import com.lalw.kamboost.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional <UserModel> findByEmailUser(String emailUser);
    Boolean existsByEmailUser(String emailUser);
}
