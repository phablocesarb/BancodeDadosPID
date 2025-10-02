package com.prav.BancodeDadosPID.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prav.BancodeDadosPID.model.PrestadorServico;
import com.prav.BancodeDadosPID.repository.PrestadorServicoRepository;

@Service
public class PrestadorServicoService {
    private final PrestadorServicoRepository repo;

    public PrestadorServicoService(PrestadorServicoRepository repo) {
        this.repo = repo;
    }

    public List<PrestadorServico> listar() {
        return repo.findAll();
    }

    public PrestadorServico salvar(PrestadorServico prestador) {
        return repo.save(prestador);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public PrestadorServico buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }
}
