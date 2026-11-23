package br.edu.exemplo;

public class ContaBancaria {
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("O depósito deve ser positivo e finito");
        }
        saldo += valor;
    }

    public void sacar(double valor) {
        if (!Double.isFinite(valor) || valor <= 0) {
            throw new IllegalArgumentException("O saque deve ser positivo e finito");
        }
        if (valor > saldo) {
            return;
        }
        saldo -= valor;
    }
}
