package org.sample.jpa.service;

import org.sample.jpa.entities.Usuario;
import org.sample.jpa.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    Usuario create(Usuario usuario);

    Usuario findById(Integer id) throws ResourceNotFoundException;
}
