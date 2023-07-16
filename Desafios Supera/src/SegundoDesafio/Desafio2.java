package SegundoDesafio;

/* Desafio 2
   Leia um valor de ponto flutuante com duas casas decimais. Este valor representa um valor
       monetário. A seguir, calcule o menor número de notas e moedas possíveis no qual o valor
       pode ser decomposto. As notas consideradas são de 100, 50, 20, 10, 5, 2. As moedas
       possíveis são de 1, 0.50, 0.25, 0.10, 0.05 e 0.01. A seguir mostre a relação de notas
       necessárias. */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;

import static java.util.Arrays.stream;


public class Desafio2 {
    private static BigDecimal valorEntrada;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Digite o valor: ");
        valorEntrada = new BigDecimal(scanner.nextLine());

        decomposeNotes();
        decomposeCoin();

    }

    public static void decomposeNotes() {
        stream(Notas.values()).map(Notas::getValor).forEachOrdered(aDouble -> System.out.println(getFunction().apply(aDouble) + " notas(s) de R$ " + getFormatDouble(aDouble)));
    }

    public static void decomposeCoin() {
        stream(Moedas.values()).map(Moedas::getValor).forEachOrdered(aDouble -> System.out.println(getFunction().apply(aDouble) + " moeda(s) de R$ " + getFormatDouble(aDouble)));
    }

    private static String getFormatDouble(Double valor) {
        return String.format(Locale.US, "%.2f", valor);
    }

    private static Function<Double, Integer> getFunction() {
        return unidadeMonetaria -> {
            Integer qtd = valorEntrada.divide(BigDecimal.valueOf(unidadeMonetaria), RoundingMode.FLOOR).intValue();
            valorEntrada = valorEntrada.subtract(BigDecimal.valueOf(unidadeMonetaria * qtd));
            return qtd;
        };
    }

    private enum Notas {
        CEM(100.0),
        CINQUENTA(50.0),
        VINTE(20.0),
        DEZ(10.0),
        CINCO(5.0),
        DOIS(2.0);

        private Double valor;

        public Double getValor() {
            return valor;
        }

        Notas(Double valor) {
            this.valor = valor;
        }
    }

    private enum Moedas {
        UM_REAL(1.0),
        CINQUENTA_CENTAVOS(0.50),
        VINTE_CINCO_CENTAVOS(0.25),
        DEZ_CENTAVOS(0.10),
        CINCO_CENTAVOS(0.05),
        UM_CENTAVO(0.01);

        private Double valor;

        public Double getValor() {
            return valor;
        }

        Moedas(Double valor) {
            this.valor = valor;
        }
    }


}
