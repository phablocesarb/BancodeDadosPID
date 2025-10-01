package com.prav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prav.model.Usuario;
import com.prav.repository.UsuarioRepository;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    public UsuarioService(UsuarioRepository repo) { this.repo = repo; }

    public List<Usuario> listar() { return repo.findAll(); }
    public Usuario salvar(Usuario usuario) { return repo.save(usuario); }
    public void deletar(Long id) { repo.deleteById(id); }
}
