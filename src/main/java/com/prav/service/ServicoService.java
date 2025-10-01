package com.prav.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prav.model.Servico;
import com.prav.repository.ServicoRepository;

@Service
public class ServicoService {
    private final ServicoRepository repo;

    public ServicoService(ServicoRepository repo) {
        this.repo = repo;
    }

    public List<Servico> listar() {
        return repo.findAll();
    }

    public Servico salvar(Servico servico) {
        return repo.save(servico);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public Servico buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
