package com.example.cdicontexto.service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

public interface LoginService {
    Optional<String> getUsername(HttpServletRequest req);

}
