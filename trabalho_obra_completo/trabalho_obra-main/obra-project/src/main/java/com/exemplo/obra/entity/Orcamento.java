package com.exemplo.obra.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orcamentos")
public class Orcamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String numero = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    private String nomeCliente;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private double areaTotal;
    private double volumeConcreto;
    private int quantidadeTijolos;
    private double custoMateriais;
    private double margemLucro;
    private double valorLucro;
    private double valorFinal;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArestaEntity> arestas = new ArrayList<>();

    public void adicionarAresta(ArestaEntity aresta) { aresta.setOrcamento(this); this.arestas.add(aresta); }
    public Long getId() { return id; }
    public String getNumero() { return numero; }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public double getAreaTotal() { return areaTotal; }
    public void setAreaTotal(double areaTotal) { this.areaTotal = areaTotal; }
    public double getVolumeConcreto() { return volumeConcreto; }
    public void setVolumeConcreto(double volumeConcreto) { this.volumeConcreto = volumeConcreto; }
    public int getQuantidadeTijolos() { return quantidadeTijolos; }
    public void setQuantidadeTijolos(int quantidadeTijolos) { this.quantidadeTijolos = quantidadeTijolos; }
    public double getCustoMateriais() { return custoMateriais; }
    public void setCustoMateriais(double custoMateriais) { this.custoMateriais = custoMateriais; }
    public double getMargemLucro() { return margemLucro; }
    public void setMargemLucro(double margemLucro) { this.margemLucro = margemLucro; }
    public double getValorLucro() { return valorLucro; }
    public void setValorLucro(double valorLucro) { this.valorLucro = valorLucro; }
    public double getValorFinal() { return valorFinal; }
    public void setValorFinal(double valorFinal) { this.valorFinal = valorFinal; }
    public List<ArestaEntity> getArestas() { return arestas; }
}
