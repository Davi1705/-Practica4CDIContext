package com.example.cdicontexto.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public interface UsuarioService {
    Optional<String> getUsername(HttpServletRequest req);
}
