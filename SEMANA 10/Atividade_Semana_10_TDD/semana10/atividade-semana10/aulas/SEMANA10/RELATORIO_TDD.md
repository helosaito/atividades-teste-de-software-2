# Semana 10 — Implementação TDD nos quatro projetos

## Resultado

Os quatro projetos foram implementados seguindo a sequência RED → GREEN → REFACTOR. Os casos fornecidos foram preservados e ampliados com testes de borda. Cada `pom.xml` inclui JaCoCo com uma checagem que falha se a cobertura de linhas ou de ramos ficar abaixo de 100%.

| Projeto | Testes finais | Resultado Maven | Linhas cobertas | Ramos cobertos |
|---|---:|---|---:|---:|
| `bubblesort-tdd` | 6 | 6 aprovados | 15/15 (100%) | 8/8 (100%) |
| `carrinho-compras-tdd` | 12 | 12 aprovados | 27/27 (100%) | 10/10 (100%) |
| `conta-bancaria-tdd-maven` | 9 | 9 aprovados | 14/14 (100%) | 10/10 (100%) |
| `estoque-tdd` | 7 | 7 aprovados | 12/12 (100%) | 6/6 (100%) |
| **Total** | **34** | **34 aprovados** | **68/68 (100%)** | **34/34 (100%)** |

## Evidência do ciclo RED

Antes das implementações, os testes existentes falharam como esperado: Bubble Sort teve 2 falhas em 3 testes; Conta Bancária, 4 falhas em 4; Estoque, 4 falhas em 6. No Carrinho, os testes dos requisitos foram escritos antes da classe e o primeiro build falhou na compilação porque ainda não existiam os métodos requeridos. Após implementar e refatorar, `mvn clean verify` passou nos quatro módulos e a regra JaCoCo de cobertura total ficou verde.

## O que foi implementado

- **Bubble Sort:** ordenação crescente estável para valores repetidos, vetor vazio e unitário; rejeição explícita de vetor nulo; encerramento antecipado quando já ordenado.
- **Carrinho:** adicionar/remover produtos, subtotal, desconto de 10% a partir de R$ 500,00 inclusive, valores monetários arredondados em centavos e validação de preço negativo/não finito.
- **Conta Bancária:** depósitos e saques acumulados, bloqueio de saldo negativo e validação de valores não positivos ou não finitos.
- **Estoque:** estoque inicial zero, entradas válidas acumuladas, saídas apenas quando disponíveis e operações não positivas sem alteração do saldo.

## Como reproduzir

Em cada uma das quatro pastas do projeto, execute:

```bash
mvn clean verify
```

`verify` executa os testes e a regra JaCoCo, exigindo 100% de cobertura de linhas e ramos do código de produção.
