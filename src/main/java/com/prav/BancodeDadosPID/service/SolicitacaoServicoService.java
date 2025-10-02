package com.prav.BancodeDadosPID.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.prav.BancodeDadosPID.model.SolicitacaoServico;
import com.prav.BancodeDadosPID.repository.SolicitacaoServicoRepository;

@Service
public class SolicitacaoServicoService {
    private final SolicitacaoServicoRepository repo;

    public SolicitacaoServicoService(SolicitacaoServicoRepository repo) {
        this.repo = repo;
    }

    public List<SolicitacaoServico> listar() {
        return repo.findAll();
    }

    public SolicitacaoServico salvar(SolicitacaoServico solicitacao) {
        return repo.save(solicitacao);
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }

    public SolicitacaoServico buscarPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Aprovar solicitação
    public SolicitacaoServico aprovar(Long id, String responsavel, String historico) {
        SolicitacaoServico s = buscarPorId(id);
        if (s != null) {
            s.setStatusAprovacao("Aprovada");
            s.setDataDecisao(LocalDateTime.now());
            s.setResponsavelDecisao(responsavel);
            s.setHistoricoDecisao(historico);
            return repo.save(s);
        }
        return null;
    }

    // Rejeitar solicitação
    public SolicitacaoServico rejeitar(Long id, String responsavel, String historico) {
        SolicitacaoServico s = buscarPorId(id);
        if (s != null) {
            s.setStatusAprovacao("Rejeitada");
            s.setDataDecisao(LocalDateTime.now());
            s.setResponsavelDecisao(responsavel);
            s.setHistoricoDecisao(historico);
            return repo.save(s);
        }
        return null;
    }
}
