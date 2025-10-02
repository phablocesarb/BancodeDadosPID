package com.prav.BancodeDadosPID.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prestador_servico")
public class PrestadorServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestador")
    private Long idPrestador;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;

    @Column(unique = true)
    private String documento;

    private String contato;

    private String status;

    @Column(name = "avaliacao_media")
    private Double avaliacaoMedia;

    @OneToMany(mappedBy = "prestador", cascade = CascadeType.ALL)
    private List<Servico> servicos;

    // Getters e Setters
    public Long getIdPrestador() { return idPrestador; }
    public void setIdPrestador(Long idPrestador) { this.idPrestador = idPrestador; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public String getTipoPessoa() { return tipoPessoa; }
    public void setTipoPessoa(String tipoPessoa) { this.tipoPessoa = tipoPessoa; }
    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Double getAvaliacaoMedia() { return avaliacaoMedia; }
    public void setAvaliacaoMedia(Double avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }
}
