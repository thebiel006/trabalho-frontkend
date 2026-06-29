
package com.exemplo.obra.service;

import org.springframework.stereotype.Service;
import com.exemplo.obra.model.Aresta;
import java.util.List;

@Service
public class ConcretoService {
    public double calcularVolume(List<Aresta> arestas, double altura) {
        double volume = 0;
        for (Aresta a : arestas) {
            volume += a.getComprimento() * altura * a.getEspessura();
        }
        return volume;
    }
}
