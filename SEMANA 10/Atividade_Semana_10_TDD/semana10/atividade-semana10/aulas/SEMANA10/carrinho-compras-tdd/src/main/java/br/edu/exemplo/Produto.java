package br.edu.exemplo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {
    private final String nome;
    private final BigDecimal preco;

    public Produto(String nome, double preco) {
        if (!Double.isFinite(preco) || preco < 0) {
            throw new IllegalArgumentException("O preço deve ser finito e não negativo");
        }
        this.nome = nome;
        this.preco = BigDecimal.valueOf(preco).setScale(2, RoundingMode.HALF_UP);
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco.doubleValue(); }
}
