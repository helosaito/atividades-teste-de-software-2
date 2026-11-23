package br.edu.exemplo;

import java.util.Objects;

public class BubbleSort {
    private final int[] numeros;

    public BubbleSort(int[] numeros) {
        this.numeros = Objects.requireNonNull(numeros, "O vetor não pode ser nulo");
    }

    public void ordenar() {
        for (int fim = numeros.length - 1; fim > 0; fim--) {
            boolean trocou = false;
            for (int i = 0; i < fim; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    int temporario = numeros[i];
                    numeros[i] = numeros[i + 1];
                    numeros[i + 1] = temporario;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
    }

    public int[] getNumeros() {
        return numeros;
    }
}
