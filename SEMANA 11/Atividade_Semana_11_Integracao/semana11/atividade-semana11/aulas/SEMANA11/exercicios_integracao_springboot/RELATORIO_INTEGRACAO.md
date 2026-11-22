# Semana 11 — Testes de integração Spring Boot

## Resultado da execução

Comando executado: `mvn clean verify` (Java 21 compilando para release 17). Resultado: **BUILD SUCCESS — 5 testes aprovados, 0 falhas, 0 erros**.

| Classe de teste | Casos | Evidência verificada |
|---|---:|---|
| `ProdutoServiceIntegrationTest` | 3 | Cadastro de Teclado com ID; leitura do registro pelo repositório H2; rejeição de nome em branco sem aumento da contagem; atualização de preço persistida de R$ 80,00 para R$ 95,00. |
| `ProdutoControllerIntegrationTest` | 2 | POST `/produtos` responde HTTP 200 e JSON com ID, nome e preço; POST seguido de GET recupera o mesmo produto pelo ID. |

## Integração e isolamento

Os testes usam o contexto real do Spring (`@SpringBootTest`), o `ProdutoService`, o `ProdutoRepository` e o banco H2 em memória, sem mocks substituindo esses componentes. Os testes HTTP usam `MockMvc` para percorrer Controller → Service → Repository → H2 sem abrir um servidor de rede real.

Uma consulta posterior com `repository.findById()` verifica que o estado pode ser recuperado da persistência; verificar apenas o objeto retornado pelo serviço não prova, por si só, uma leitura subsequente do repositório. `@Transactional` mantém as operações do teste em uma transação e, normalmente, o Spring a desfaz ao final de cada método, isolando os dados entre os casos.

## Como reproduzir

Na pasta deste projeto, execute:

```bash
mvn clean verify
```
