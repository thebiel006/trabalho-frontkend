package com.exemplo.obra.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "arestas_orcamento")
public class ArestaEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double comprimento;
    private double altura;
    private double espessura;
    private boolean temPorta;
    private boolean temJanela;
    private double alturaAbertura;
    private double larguraAbertura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

    public double getAreaParede() {
        double area = comprimento * altura;
        if (temPorta || temJanela) area -= alturaAbertura * larguraAbertura;
        return Math.max(area, 0);
    }
    public Long getId() { return id; }
    public double getComprimento() { return comprimento; }
    public void setComprimento(double comprimento) { this.comprimento = comprimento; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public double getEspessura() { return espessura; }
    public void setEspessura(double espessura) { this.espessura = espessura; }
    public boolean isTemPorta() { return temPorta; }
    public void setTemPorta(boolean temPorta) { this.temPorta = temPorta; }
    public boolean isTemJanela() { return temJanela; }
    public void setTemJanela(boolean temJanela) { this.temJanela = temJanela; }
    public double getAlturaAbertura() { return alturaAbertura; }
    public void setAlturaAbertura(double alturaAbertura) { this.alturaAbertura = alturaAbertura; }
    public double getLarguraAbertura() { return larguraAbertura; }
    public void setLarguraAbertura(double larguraAbertura) { this.larguraAbertura = larguraAbertura; }
    public Orcamento getOrcamento() { return orcamento; }
    public void setOrcamento(Orcamento orcamento) { this.orcamento = orcamento; }
}
