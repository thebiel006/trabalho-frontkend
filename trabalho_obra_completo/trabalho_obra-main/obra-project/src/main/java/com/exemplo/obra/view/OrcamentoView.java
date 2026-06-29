package com.exemplo.obra.view;

import com.exemplo.obra.dto.ArestaInputDTO;
import com.exemplo.obra.dto.OrcamentoRequestDTO;
import com.exemplo.obra.dto.OrcamentoResponseDTO;
import com.exemplo.obra.entity.Orcamento;
import com.exemplo.obra.service.OrcamentoService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.List;

@Component("orcamentoView")
@Scope("session")
public class OrcamentoView implements Serializable {
    private final OrcamentoService service;
    private OrcamentoRequestDTO solicitacao = new OrcamentoRequestDTO();
    private OrcamentoResponseDTO resultado;
    private String numeroBusca;
    private String mensagem;

    public OrcamentoView(OrcamentoService service) { this.service = service; }

    @PostConstruct
    public void iniciar() { adicionarParede(); }
    public void adicionarParede() { solicitacao.getArestas().add(new ArestaInputDTO()); }
    public void removerParede(ArestaInputDTO aresta) { solicitacao.getArestas().remove(aresta); }
    public void calcular() {
        try { resultado = OrcamentoResponseDTO.from(service.criar(solicitacao)); mensagem = "Orçamento gerado com sucesso."; }
        catch (Exception e) { mensagem = e.getMessage(); }
    }
    public void buscar() {
        try { resultado = OrcamentoResponseDTO.from(service.buscarPorNumero(numeroBusca)); mensagem = "Orçamento localizado."; }
        catch (Exception e) { mensagem = e.getMessage(); }
    }
    public List<Orcamento> getOrcamentos() { return service.listar(); }
    public OrcamentoRequestDTO getSolicitacao() { return solicitacao; }
    public OrcamentoResponseDTO getResultado() { return resultado; }
    public String getNumeroBusca() { return numeroBusca; }
    public void setNumeroBusca(String numeroBusca) { this.numeroBusca = numeroBusca; }
    public String getMensagem() { return mensagem; }
}
