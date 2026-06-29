package com.exemplo.obra.controller;

import com.exemplo.obra.dto.ConcretoDTO;
import com.exemplo.obra.dto.OrcamentoRequestDTO;
import com.exemplo.obra.dto.OrcamentoResponseDTO;
import com.exemplo.obra.dto.TijoloDTO;
import com.exemplo.obra.service.ConcretoService;
import com.exemplo.obra.service.OrcamentoService;
import com.exemplo.obra.service.TijoloService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obra")
public class ObraController {
    private final ConcretoService concretoService;
    private final TijoloService tijoloService;
    private final OrcamentoService orcamentoService;

    public ObraController(ConcretoService concretoService, TijoloService tijoloService, OrcamentoService orcamentoService) {
        this.concretoService = concretoService;
        this.tijoloService = tijoloService;
        this.orcamentoService = orcamentoService;
    }

    @GetMapping("/teste")
    public String teste() { return "API funcionando!"; }

    @PostMapping("/concreto")
    public double calcularConcreto(@RequestBody ConcretoDTO dto) { return concretoService.calcularVolume(dto.getArestas(), dto.getAltura()); }

    @PostMapping("/tijolos")
    public int calcularTijolos(@RequestBody TijoloDTO dto) { return tijoloService.calcularQuantidade(dto.getArestas(), dto.getAlturaTijolo(), dto.getLarguraTijolo()); }

    @PostMapping("/orcamentos")
    public OrcamentoResponseDTO criarOrcamento(@RequestBody OrcamentoRequestDTO dto) { return OrcamentoResponseDTO.from(orcamentoService.criar(dto)); }

    @GetMapping("/orcamentos")
    public List<OrcamentoResponseDTO> listarOrcamentos() { return orcamentoService.listar().stream().map(OrcamentoResponseDTO::from).toList(); }

    @GetMapping("/orcamentos/{numero}")
    public OrcamentoResponseDTO buscarPorNumero(@PathVariable String numero) { return OrcamentoResponseDTO.from(orcamentoService.buscarPorNumero(numero)); }
}
