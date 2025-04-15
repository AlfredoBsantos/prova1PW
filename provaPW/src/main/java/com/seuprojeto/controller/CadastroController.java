package com.seuprojeto.controller;

import com.seuprojeto.model.Usuario;
import com.seuprojeto.repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
    @Autowired
    private UsuarioRepository repository;

    @GetMapping
    public String mostrarForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping
    public String cadastrar(Usuario usuario, HttpSession session) {
        repository.save(usuario);
        session.setAttribute("usuarioLogado", usuario);
        return "redirect:/dashboard";
    }
}