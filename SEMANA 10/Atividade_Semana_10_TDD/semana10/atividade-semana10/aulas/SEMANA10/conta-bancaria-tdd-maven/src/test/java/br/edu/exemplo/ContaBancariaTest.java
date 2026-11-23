package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {
    @Test void saldoInicialEZero() { assertEquals(0, new ContaBancaria().getSaldo(), 0.001); }
    @Test void deveDepositarValorNaConta() { ContaBancaria c=new ContaBancaria(); c.depositar(100); assertEquals(100,c.getSaldo(),0.001); }
    @Test void deveAcumularDepositos() { ContaBancaria c=new ContaBancaria(); c.depositar(100); c.depositar(50); assertEquals(150,c.getSaldo(),0.001); }
    @Test void deveSacarValorDaConta() { ContaBancaria c=new ContaBancaria(); c.depositar(100); c.sacar(40); assertEquals(60,c.getSaldo(),0.001); }
    @Test void naoDevePermitirSaqueMaiorQueSaldo() { ContaBancaria c=new ContaBancaria(); c.depositar(100); c.sacar(150); assertEquals(100,c.getSaldo(),0.001); }
    @Test void rejeitaDepositoNaoPositivo() { ContaBancaria c=new ContaBancaria(); assertThrows(IllegalArgumentException.class,()->c.depositar(0)); assertThrows(IllegalArgumentException.class,()->c.depositar(-1)); assertEquals(0,c.getSaldo(),0.001); }
    @Test void rejeitaSaqueNaoPositivo() { ContaBancaria c=new ContaBancaria(); c.depositar(100); assertThrows(IllegalArgumentException.class,()->c.sacar(0)); assertThrows(IllegalArgumentException.class,()->c.sacar(-1)); assertEquals(100,c.getSaldo(),0.001); }

    @Test void rejeitaDepositoNaoFinito() {
        ContaBancaria c=new ContaBancaria(); assertThrows(IllegalArgumentException.class,()->c.depositar(Double.NaN)); assertEquals(0,c.getSaldo(),0.001);
    }
    @Test void rejeitaSaqueNaoFinito() {
        ContaBancaria c=new ContaBancaria(); c.depositar(100); assertThrows(IllegalArgumentException.class,()->c.sacar(Double.POSITIVE_INFINITY)); assertEquals(100,c.getSaldo(),0.001);
    }
}
