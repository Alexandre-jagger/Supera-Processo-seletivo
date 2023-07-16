package TerceiroDesafio;

/* Desafio 3
   Dado um array de inteiros e um valor alvo, determine o número de pares entre os elementos
   do array em que a sua diferença seja igual ao valor alvo. */


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Desafio3 {
    private static Integer count1 = 0;

    public static void main(String[] args) {
        List<Integer> lista = Stream.of(1,2,3,4).sorted().collect(Collectors.toList());
        Integer alvo = 1;

        System.out.println(countPairsWithDifference(lista, alvo));
    }

    private static int countPairsWithDifference(List<Integer> lista, Integer k) {

        lista.forEach(x -> {
            count1 += lista.stream().filter(y -> x - y == k).toList().size();
        } );

        return count1;
    }

}