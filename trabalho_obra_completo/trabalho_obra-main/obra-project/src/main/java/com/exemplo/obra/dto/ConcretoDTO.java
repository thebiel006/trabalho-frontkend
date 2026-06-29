
package com.exemplo.obra.dto;

import java.util.List;
import com.exemplo.obra.model.Aresta;

public class ConcretoDTO {
    private List<Aresta> arestas;
    private double altura;

    public List<Aresta> getArestas() { return arestas; }
    public void setArestas(List<Aresta> arestas) { this.arestas = arestas; }

    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
}
