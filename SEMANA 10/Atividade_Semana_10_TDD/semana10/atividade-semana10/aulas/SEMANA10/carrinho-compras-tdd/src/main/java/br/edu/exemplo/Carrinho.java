package br.edu.exemplo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private static final BigDecimal LIMITE_DESCONTO = new BigDecimal("500.00");
    private static final BigDecimal TAXA_DESCONTO = new BigDecimal("0.10");
    private final List<Produto> produtos = new ArrayList<>();

    public void adicionarProduto(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto não pode ser nulo");
        }
        produtos.add(produto);
    }

    public boolean removerProduto(Produto produto) {
        return produtos.remove(produto);
    }

    public double getSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (Produto produto : produtos) {
            subtotal = subtotal.add(BigDecimal.valueOf(produto.getPreco()));
        }
        return subtotal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double getDesconto() {
        BigDecimal subtotal = BigDecimal.valueOf(getSubtotal());
        if (subtotal.compareTo(LIMITE_DESCONTO) >= 0) {
            return subtotal.multiply(TAXA_DESCONTO).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }
        return 0.0;
    }

    public double getTotal() {
        return BigDecimal.valueOf(getSubtotal()).subtract(BigDecimal.valueOf(getDesconto())).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
