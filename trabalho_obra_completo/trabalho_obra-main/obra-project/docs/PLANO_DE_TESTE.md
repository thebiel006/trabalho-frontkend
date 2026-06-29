# Plano de Teste - Calculadora de Materiais para Obra Residencial

## Objetivo
Validar se o sistema permite cadastrar uma solicitação de orçamento, calcular materiais e valores, salvar no banco de dados e consultar o orçamento pelo número gerado.

## Cenários

| Nº | Funcionalidade | Dados de teste | Resultado esperado | Status |
|---|---|---|---|---|
| 1 | Abrir tela JSF | Acessar `http://localhost:8080/index.xhtml` | Tela de orçamento exibida | A executar |
| 2 | Calcular orçamento | 2 paredes, tijolo 0,19x0,39, margem 20% | Sistema calcula área, concreto, tijolos, custo e valor final | A executar |
| 3 | Salvar orçamento | Após clicar em calcular | Registro salvo na tabela `orcamentos` | A executar |
| 4 | Buscar orçamento | Número gerado pelo sistema | Sistema apresenta o orçamento salvo | A executar |
| 5 | API REST | POST `/api/obra/orcamentos` com JSON válido | Retorna JSON com número, custos e valor final | A executar |
| 6 | Validação | Enviar parede sem comprimento/altura | Sistema informa erro de validação | A executar |

## Evidências esperadas
- Print da tela inicial.
- Print do resultado do orçamento.
- Print da consulta por número.
- Print da listagem no H2 Console ou retorno da API.
