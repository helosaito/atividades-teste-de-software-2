package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {
    @Test void produtoDeveIniciarComEstoqueZero() { Produto p=new Produto("Teclado"); assertEquals("Teclado",p.getNome()); assertEquals(0,p.getQuantidade()); }
    @Test void deveAdicionarProdutoAoEstoque() { Produto p=new Produto("Teclado"); p.adicionarEstoque(10); assertEquals(10,p.getQuantidade()); }
    @Test void deveAcumularQuantidadeEmEstoque() { Produto p=new Produto("Teclado"); p.adicionarEstoque(10); p.adicionarEstoque(5); assertEquals(15,p.getQuantidade()); }
    @Test void deveRetirarProdutoDoEstoque() { Produto p=new Produto("Teclado"); p.adicionarEstoque(10); p.retirarEstoque(3); assertEquals(7,p.getQuantidade()); }
    @Test void naoDeveRetirarQuantidadeMaiorQueEstoque() { Produto p=new Produto("Teclado"); p.adicionarEstoque(10); p.retirarEstoque(15); assertEquals(10,p.getQuantidade()); }
    @Test void naoDeveAdicionarQuantidadeNaoPositiva() { Produto p=new Produto("Teclado"); p.adicionarEstoque(-10); p.adicionarEstoque(0); assertEquals(0,p.getQuantidade()); }
    @Test void naoDeveRetirarQuantidadeNaoPositiva() { Produto p=new Produto("Teclado"); p.adicionarEstoque(10); p.retirarEstoque(-3); p.retirarEstoque(0); assertEquals(10,p.getQuantidade()); }
}
