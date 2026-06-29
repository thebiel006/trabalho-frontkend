package com.exemplo.obra.service;

import com.exemplo.obra.dto.ArestaInputDTO;
import com.exemplo.obra.dto.OrcamentoRequestDTO;
import com.exemplo.obra.entity.ArestaEntity;
import com.exemplo.obra.entity.Orcamento;
import com.exemplo.obra.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrcamentoService {
    private final OrcamentoRepository repository;
    public OrcamentoService(OrcamentoRepository repository) { this.repository = repository; }

    public Orcamento criar(OrcamentoRequestDTO dto) {
        validar(dto);
        Orcamento orcamento = new Orcamento();
        orcamento.setNomeCliente(dto.getNomeCliente());
        double areaTotal = 0;
        double volumeConcreto = 0;
        for (ArestaInputDTO item : dto.getArestas()) {
            ArestaEntity a = toEntity(item);
            areaTotal += a.getAreaParede();
            volumeConcreto += a.getComprimento() * a.getAltura() * a.getEspessura();
            orcamento.adicionarAresta(a);
        }
        int qtdTijolos = (int) Math.ceil(areaTotal / (dto.getAlturaTijolo() * dto.getLarguraTijolo()));
        double custoMateriais = (qtdTijolos * dto.getPrecoTijolo()) + (volumeConcreto * dto.getPrecoMetroCubicoConcreto());
        double valorLucro = custoMateriais * (dto.getMargemLucro() / 100.0);
        orcamento.setAreaTotal(arredondar(areaTotal));
        orcamento.setVolumeConcreto(arredondar(volumeConcreto));
        orcamento.setQuantidadeTijolos(qtdTijolos);
        orcamento.setCustoMateriais(arredondar(custoMateriais));
        orcamento.setMargemLucro(dto.getMargemLucro());
        orcamento.setValorLucro(arredondar(valorLucro));
        orcamento.setValorFinal(arredondar(custoMateriais + valorLucro));
        return repository.save(orcamento);
    }

    public List<Orcamento> listar() { return repository.findAll(); }
    public Orcamento buscarPorNumero(String numero) { return repository.findByNumero(numero).orElseThrow(() -> new IllegalArgumentException("Orçamento não encontrado: " + numero)); }
    public Orcamento buscarPorNome(String nome) { return repository.findByNomeClienteIgnoreCase(nome).orElseThrow(() -> new IllegalArgumentException("Orçamento não encontrado para o cliente: " + nome)); }

    private void validar(OrcamentoRequestDTO dto) {
        if (dto.getArestas() == null || dto.getArestas().isEmpty()) throw new IllegalArgumentException("Informe pelo menos uma parede/aresta.");
        if (dto.getAlturaTijolo() <= 0 || dto.getLarguraTijolo() <= 0) throw new IllegalArgumentException("Medidas do tijolo devem ser maiores que zero.");
        if (dto.getMargemLucro() < 0) throw new IllegalArgumentException("Margem de lucro não pode ser negativa.");
    }
    private ArestaEntity toEntity(ArestaInputDTO dto) {
        if (dto.getComprimento() <= 0 || dto.getAltura() <= 0 || dto.getEspessura() <= 0) throw new IllegalArgumentException("Comprimento, altura e espessura precisam ser maiores que zero.");
        ArestaEntity a = new ArestaEntity();
        a.setComprimento(dto.getComprimento()); a.setAltura(dto.getAltura()); a.setEspessura(dto.getEspessura());
        a.setTemPorta(dto.isTemPorta()); a.setTemJanela(dto.isTemJanela());
        a.setAlturaAbertura(dto.getAlturaAbertura()); a.setLarguraAbertura(dto.getLarguraAbertura());
        return a;
    }
    private double arredondar(double valor) { return Math.round(valor * 100.0) / 100.0; }
}
