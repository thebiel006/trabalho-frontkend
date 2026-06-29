package com.exemplo.obra.dto;

import java.util.ArrayList;
import java.util.List;

public class OrcamentoRequestDTO {
    private String nomeCliente;
    private List<ArestaInputDTO> arestas = new ArrayList<>();
    private double alturaTijolo = 0.19;
    private double larguraTijolo = 0.39;
    private double precoTijolo = 1.20;
    private double precoMetroCubicoConcreto = 450.00;
    private double margemLucro = 20.0;
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public List<ArestaInputDTO> getArestas() { return arestas; }
    public void setArestas(List<ArestaInputDTO> arestas) { this.arestas = arestas; }
    public double getAlturaTijolo() { return alturaTijolo; }
    public void setAlturaTijolo(double alturaTijolo) { this.alturaTijolo = alturaTijolo; }
    public double getLarguraTijolo() { return larguraTijolo; }
    public void setLarguraTijolo(double larguraTijolo) { this.larguraTijolo = larguraTijolo; }
    public double getPrecoTijolo() { return precoTijolo; }
    public void setPrecoTijolo(double precoTijolo) { this.precoTijolo = precoTijolo; }
    public double getPrecoMetroCubicoConcreto() { return precoMetroCubicoConcreto; }
    public void setPrecoMetroCubicoConcreto(double precoMetroCubicoConcreto) { this.precoMetroCubicoConcreto = precoMetroCubicoConcreto; }
    public double getMargemLucro() { return margemLucro; }
    public void setMargemLucro(double margemLucro) { this.margemLucro = margemLucro; }
}
