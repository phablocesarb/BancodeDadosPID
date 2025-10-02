package com.prav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prav.model.Usuario;
import com.prav.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
