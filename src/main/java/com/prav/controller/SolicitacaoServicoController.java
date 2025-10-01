package com.prav.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.model.SolicitacaoServico;
import com.prav.service.SolicitacaoServicoService;

@RestController
@RequestMapping("/solicitacoes")
public class SolicitacaoServicoController {
    private final SolicitacaoServicoService service;

    public SolicitacaoServicoController(SolicitacaoServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<SolicitacaoServico> listar() {
        return service.listar();
    }

    @PostMapping
    public SolicitacaoServico criar(@RequestBody SolicitacaoServico solicitacao) {
        return service.salvar(solicitacao);
    }

    @PutMapping("/{id}")
    public SolicitacaoServico atualizar(@PathVariable Long id, @RequestBody SolicitacaoServico solicitacao) {
        solicitacao.setIdSolicitacao(id);
        return service.salvar(solicitacao);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // Aprovar solicitação
    @PutMapping("/{id}/aprovar")
    public SolicitacaoServico aprovar(@PathVariable Long id, @RequestBody Map<String,String> body) {
        return service.aprovar(
            id,
            body.getOrDefault("responsavel", "Administrador"),
            body.getOrDefault("historico", "Aprovado via API")
        );
    }

    // Rejeitar solicitação
    @PutMapping("/{id}/rejeitar")
    public SolicitacaoServico rejeitar(@PathVariable Long id, @RequestBody Map<String,String> body) {
        return service.rejeitar(
            id,
            body.getOrDefault("responsavel", "Administrador"),
            body.getOrDefault("historico", "Rejeitado via API")
        );
    }
}
