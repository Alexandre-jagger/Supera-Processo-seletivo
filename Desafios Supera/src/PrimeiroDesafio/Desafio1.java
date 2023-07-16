package PrimeiroDesafio;


/* Desafio 1
   Considerando a entrada de valores inteiros não negativos, ordene estes valores segundo
   o seguinte critério:
        • Primeiro os Pares
        • Depois os Ímpares
   Sendo que deverão ser apresentados os pares em ordem crescente e depois os ímpares
   em ordem decrescente. */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Desafio1 {
    public static void main(String[] args) {


        int n = 5;
        int[] valores = {4, 7, 2, 9, 6};
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int valor = valores[i];
            if (valor % 2 == 0){
                pares.add(valor);
            } else {
                impares.add(valor);
            }


        }
        Collections.sort(pares);
        Collections.sort(impares, Collections.reverseOrder());

        for (int valor : pares) {
            System.out.println(valor);
        }

        for (int valor : impares) {
            System.out.println(valor);
        }

    }
}