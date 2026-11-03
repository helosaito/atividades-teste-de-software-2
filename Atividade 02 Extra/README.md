# Pife básico em Java

Jogo de cartas em terminal, sem bibliotecas externas. Uma pessoa joga contra computadores.

## Requisitos

- JDK 17 ou superior no `PATH`.
- No Windows, use `run.bat` para jogar e `test.bat` para testar.

## Executar no Windows

```bat
run.bat
test.bat
```

## Executar em Linux ou macOS

```bash
mkdir -p out
javac -encoding UTF-8 -d out src/main/java/pife/*.java
java -cp out pife.Main
```

Para os testes:

```bash
javac -encoding UTF-8 -d out src/main/java/pife/*.java src/test/java/pife/*.java
java -cp out pife.CardTest
java -cp out pife.PifeGameTest
```

## Variante básica usada

São usados dois baralhos comuns, sem curingas. Cada participante começa com 9 cartas. Em cada turno, compra uma carta do monte ou a última carta descartada e depois descarta uma carta. A rodada termina quando as 9 cartas que ficaram na mão podem ser divididas em três jogos de três cartas.

Um jogo pode ser uma trinca de mesmo valor e naipes diferentes ou uma sequência de três cartas do mesmo naipe. O Ás pode participar de A-2-3 ou Q-K-A. Não há pontuação, rodadas acumuladas, coringa ou regra de bater fora da vez.
