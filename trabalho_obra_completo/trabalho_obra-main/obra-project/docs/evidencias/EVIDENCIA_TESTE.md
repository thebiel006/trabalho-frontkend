# Evidências de execução

Como este arquivo foi preparado fora do ambiente do professor, as evidências devem ser preenchidas após rodar o projeto localmente.

## Passos para gerar evidências
1. Executar `mvn spring-boot:run`.
2. Acessar `http://localhost:8080/index.xhtml`.
3. Cadastrar paredes e clicar em **Calcular e salvar orçamento**.
4. Copiar o número gerado e testar a busca.
5. Abrir o H2 Console em `http://localhost:8080/h2-console` e verificar as tabelas `orcamentos` e `arestas_orcamento`.

## Resultado esperado
O sistema deve calcular e persistir o orçamento, mantendo número identificador para busca.
