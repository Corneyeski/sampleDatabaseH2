package org.sample.jpa.service;

import org.sample.jpa.entities.Usuario;
import org.sample.jpa.exceptions.ResourceNotFoundException;
import org.sample.jpa.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario findById(Integer id) throws ResourceNotFoundException {
        return usuarioRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }
}
