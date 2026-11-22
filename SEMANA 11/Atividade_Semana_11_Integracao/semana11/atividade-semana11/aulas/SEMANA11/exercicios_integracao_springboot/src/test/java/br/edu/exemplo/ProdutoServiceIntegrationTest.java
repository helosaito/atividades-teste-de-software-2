package br.edu.exemplo;

import br.edu.exemplo.model.Produto;
import br.edu.exemplo.repository.ProdutoRepository;
import br.edu.exemplo.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest @Transactional
class ProdutoServiceIntegrationTest {
    @Autowired ProdutoService service;
    @Autowired ProdutoRepository repository;
    @Test void deveCadastrarERecuperarProduto() {
        Produto criado=service.cadastrar("Teclado",150.0); assertNotNull(criado.getId());
        Produto salvo=repository.findById(criado.getId()).orElseThrow(); assertEquals("Teclado",salvo.getNome()); assertEquals(150.0,salvo.getPreco(),0.0001);
    }
    @Test void naoDevePersistirProdutoComNomeEmBranco() {
        long antes=repository.count(); assertThrows(IllegalArgumentException.class,()->service.cadastrar("   ",80.0)); assertEquals(antes,repository.count());
    }
    @Test void deveAtualizarPrecoPersistido() {
        Produto criado=service.cadastrar("Mouse",80.0); service.atualizarPreco(criado.getId(),95.0);
        assertEquals(95.0,repository.findById(criado.getId()).orElseThrow().getPreco(),0.0001);
    }
}
