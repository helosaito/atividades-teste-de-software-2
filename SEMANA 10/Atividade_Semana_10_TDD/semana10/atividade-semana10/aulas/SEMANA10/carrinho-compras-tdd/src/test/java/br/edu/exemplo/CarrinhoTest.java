package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoTest {
    @Test void carrinhoNovoTemTotalZero() { assertEquals(0.0,new Carrinho().getTotal(),0.0001); }
    @Test void adicionaProdutoECalculaTotal() { Carrinho c=new Carrinho(); Produto p=new Produto("Teclado",100); c.adicionarProduto(p); assertEquals("Teclado",p.getNome()); assertEquals(100,p.getPreco(),0.0001); assertEquals(100,c.getTotal(),0.0001); assertEquals(100,c.getSubtotal(),0.0001); assertEquals(0,c.getDesconto(),0.0001); }
    @Test void somaVariosProdutos() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Teclado",100)); c.adicionarProduto(new Produto("Mouse",50)); assertEquals(150,c.getTotal(),0.0001); }
    @Test void removeProdutoAdicionado() { Carrinho c=new Carrinho(); Produto a=new Produto("Teclado",100), b=new Produto("Mouse",50); c.adicionarProduto(a); c.adicionarProduto(b); assertTrue(c.removerProduto(b)); assertEquals(100,c.getTotal(),0.0001); }
    @Test void removerProdutoAusenteNaoAlteraCarrinho() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Teclado",100)); assertFalse(c.removerProduto(new Produto("Mouse",50))); assertEquals(100,c.getTotal(),0.0001); }
    @Test void rejeitaPrecoNegativo() { assertThrows(IllegalArgumentException.class,()->new Produto("Teclado",-100)); }
    @Test void precoZeroEValido() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Amostra",0)); assertEquals(0,c.getTotal(),0.0001); }
    @Test void rejeitaProdutoNulo() { assertThrows(IllegalArgumentException.class,()->new Carrinho().adicionarProduto(null)); }
    @Test void aplicaDescontoNoLimiteDeQuinhentos() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Compra",500)); assertEquals(500,c.getSubtotal(),0.0001); assertEquals(50,c.getDesconto(),0.0001); assertEquals(450,c.getTotal(),0.0001); }
    @Test void naoAplicaDescontoAbaixoDoLimite() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Compra",499.99)); assertEquals(0,c.getDesconto(),0.0001); assertEquals(499.99,c.getTotal(),0.0001); }
    @Test void aplicaDescontoAcimaDoLimiteComArredondamentoMonetario() { Carrinho c=new Carrinho(); c.adicionarProduto(new Produto("Compra",500.01)); assertEquals(50.00,c.getDesconto(),0.0001); assertEquals(450.01,c.getTotal(),0.0001); }

    @Test void rejeitaPrecoNaoFinito() {
        assertThrows(IllegalArgumentException.class, () -> new Produto("NaN", Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> new Produto("Infinito", Double.POSITIVE_INFINITY));
    }
}
