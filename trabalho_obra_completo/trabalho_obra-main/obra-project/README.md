# Calculadora de Materiais para Obra Residencial

Projeto em Java/Spring Boot com tela em Jakarta Faces, persistência com JPA/H2 e endpoints REST.

## O que foi adicionado
- Tela JSF (`index.xhtml`) para o usuário informar a planta da casa por paredes/arestas.
- Campos de porta/janela para descontar aberturas.
- Cálculo de área, volume de concreto, quantidade de tijolos, custo de materiais, margem de lucro e valor final.
- Banco H2 com tabelas `orcamentos` e `arestas_orcamento`.
- Busca de orçamento por número identificador.
- Endpoints REST para testes.
- Plano de teste e arquivo de evidências em `docs/`.

## Como executar
```bash
cd obra-project
mvn spring-boot:run
```

Depois acesse:
- Tela: `http://localhost:8080/index.xhtml`
- Teste API: `http://localhost:8080/api/obra/teste`
- H2 Console: `http://localhost:8080/h2-console`

Dados do H2:
- JDBC URL: `jdbc:h2:mem:obra`
- Usuário: `sa`
- Senha: deixe em branco

## Exemplo de JSON para API
```json
{
  "nomeCliente": "Cliente Teste",
  "alturaTijolo": 0.19,
  "larguraTijolo": 0.39,
  "precoTijolo": 1.20,
  "precoMetroCubicoConcreto": 450,
  "margemLucro": 20,
  "arestas": [
    {"comprimento": 10, "altura": 3, "espessura": 0.15, "temPorta": true, "alturaAbertura": 2.10, "larguraAbertura": 0.80},
    {"comprimento": 5, "altura": 3, "espessura": 0.15, "temJanela": true, "alturaAbertura": 1.20, "larguraAbertura": 1.50}
  ]
}
```

Endpoint: `POST http://localhost:8080/api/obra/orcamentos`
