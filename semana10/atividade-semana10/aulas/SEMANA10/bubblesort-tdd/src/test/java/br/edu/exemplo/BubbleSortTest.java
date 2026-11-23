package br.edu.exemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @Test void deveOrdenarVetorDesordenado() {
        BubbleSort sort = new BubbleSort(new int[]{5, 3, 1, 4, 2}); sort.ordenar();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sort.getNumeros());
    }
    @Test void deveManterVetorJaOrdenado() {
        BubbleSort sort = new BubbleSort(new int[]{1, 2, 3, 4, 5}); sort.ordenar();
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sort.getNumeros());
    }
    @Test void deveOrdenarVetorComValoresRepetidos() {
        BubbleSort sort = new BubbleSort(new int[]{3, 1, 3, 2, 1}); sort.ordenar();
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, sort.getNumeros());
    }
    @Test void vetorVazioEValido() {
        BubbleSort sort = new BubbleSort(new int[]{}); sort.ordenar(); assertArrayEquals(new int[]{}, sort.getNumeros());
    }
    @Test void vetorUnitarioEValido() {
        BubbleSort sort = new BubbleSort(new int[]{7}); sort.ordenar(); assertArrayEquals(new int[]{7}, sort.getNumeros());
    }
    @Test void rejeitaVetorNulo() { assertThrows(NullPointerException.class, () -> new BubbleSort(null)); }
}
