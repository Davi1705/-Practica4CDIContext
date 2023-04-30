package com.example.cdicontexto.servlet;

import com.example.cdicontexto.model.Usuario;
import com.example.cdicontexto.service.LoginService;
import com.example.cdicontexto.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Inject
    private LoginService auth;
    @Inject
    private UsuarioService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<Usuario> usuarioOptional = service.login(username, password);
        Optional<String> usernameOptional = auth.getUsername(req);

        if (usuarioOptional.isPresent() && usernameOptional.isPresent()) {
            // El usuario está autenticado y su nombre de usuario es válido
            // Redirige al usuario a la página de inicio o página principal
            resp.sendRedirect(req.getContextPath() + "/home");
        } else {
            // El usuario no está autenticado o su nombre de usuario no es válido
            // Redirige al usuario de nuevo a la página de inicio de sesión con un mensaje de error
            req.setAttribute("error", "Nombre de usuario o contraseña inválido");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
