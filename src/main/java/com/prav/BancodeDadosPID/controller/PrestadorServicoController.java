package com.prav.BancodeDadosPID.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prav.BancodeDadosPID.model.PrestadorServico;
import com.prav.BancodeDadosPID.service.PrestadorServicoService;

@RestController
@RequestMapping("/prestadores")
public class PrestadorServicoController {
    private final PrestadorServicoService service;

    public PrestadorServicoController(PrestadorServicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrestadorServico> listar() {
        return service.listar();
    }

    @PostMapping
    public PrestadorServico criar(@RequestBody PrestadorServico prestador) {
        return service.salvar(prestador);
    }

    @PutMapping("/{id}")
    public PrestadorServico atualizar(@PathVariable Long id, @RequestBody PrestadorServico prestador) {
        prestador.setIdPrestador(id);
        return service.salvar(prestador);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
