
package com.exemplo.obra.model;

public class Aresta {

    private double comprimento;
    private double altura;
    private double espessura;
    private boolean temPorta;
    private boolean temJanela;
    private double alturaAbertura;
    private double larguraAbertura;

    public double getAreaParede() {
        double area = comprimento * altura;
        if (temPorta || temJanela) {
            area -= (alturaAbertura * larguraAbertura);
        }
        return area;
    }

    public double getComprimento() { return comprimento; }
    public double getAltura() { return altura; }
    public double getEspessura() { return espessura; }
    public boolean isTemPorta() { return temPorta; }
    public boolean isTemJanela() { return temJanela; }
    public double getAlturaAbertura() { return alturaAbertura; }
    public double getLarguraAbertura() { return larguraAbertura; }

    public void setComprimento(double comprimento) { this.comprimento = comprimento; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setEspessura(double espessura) { this.espessura = espessura; }
    public void setTemPorta(boolean temPorta) { this.temPorta = temPorta; }
    public void setTemJanela(boolean temJanela) { this.temJanela = temJanela; }
    public void setAlturaAbertura(double alturaAbertura) { this.alturaAbertura = alturaAbertura; }
    public void setLarguraAbertura(double larguraAbertura) { this.larguraAbertura = larguraAbertura; }
}
