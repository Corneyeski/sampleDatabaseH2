package org.sample.jpa.controller;

import org.sample.jpa.entities.Usuario;
import org.sample.jpa.exceptions.ResourceNotFoundException;
import org.sample.jpa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jpa/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) throws ResourceNotFoundException {
        return usuarioService.findById(id);
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.create(usuario);
    }
}
