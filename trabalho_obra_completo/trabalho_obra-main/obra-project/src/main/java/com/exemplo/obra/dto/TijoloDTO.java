
package com.exemplo.obra.dto;

import java.util.List;
import com.exemplo.obra.model.Aresta;

public class TijoloDTO {
    private List<Aresta> arestas;
    private double alturaTijolo;
    private double larguraTijolo;

    public List<Aresta> getArestas() { return arestas; }
    public void setArestas(List<Aresta> arestas) { this.arestas = arestas; }

    public double getAlturaTijolo() { return alturaTijolo; }
    public void setAlturaTijolo(double alturaTijolo) { this.alturaTijolo = alturaTijolo; }

    public double getLarguraTijolo() { return larguraTijolo; }
    public void setLarguraTijolo(double larguraTijolo) { this.larguraTijolo = larguraTijolo; }
}
