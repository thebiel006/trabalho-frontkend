
package com.exemplo.obra.service;

import org.springframework.stereotype.Service;
import com.exemplo.obra.model.Aresta;
import java.util.List;

@Service
public class TijoloService {
    public int calcularQuantidade(List<Aresta> arestas, double alturaTijolo, double larguraTijolo) {
        double areaTotal = 0;
        for (Aresta a : arestas) {
            areaTotal += a.getAreaParede();
        }
        double areaTijolo = alturaTijolo * larguraTijolo;
        return (int) Math.ceil(areaTotal / areaTijolo);
    }
}
