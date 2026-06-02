package com.lalw.kamboost.dto;

import com.lalw.kamboost.models.UserRole;

public record RegisterDto(String nomeUser, String emailUser, String senhaUser, UserRole role) {
}
