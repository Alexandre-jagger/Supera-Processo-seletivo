package QuartoDesafio;

/* Desafio 4
    Da mesma forma, a linha " MANGOS " está sendo impressa incorretamente como
    "NAM SOG". Sua tarefa é desembaralhar (decifrar) a string a partir da forma como ela foi
    impressa para a sua forma original. Você pode assumir que cada linha conterá um número
    par de caracteres.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Colocar um numero primeiro para rodar o codigo sem erros

public class Desafio4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String linha = br.readLine();
            String linhaDesembaralhada = desembaralharTexto(linha);
            System.out.println(linhaDesembaralhada);
        }
    }

    private static String desembaralharTexto(String linha) {
        int tamanho = linha.length();
        StringBuilder sb = new StringBuilder();

        for (int i = tamanho / 2 - 1; i >= 0; i--) {
            sb.append(linha.charAt(i));
        }

        for (int i = tamanho - 1; i >= tamanho / 2; i--) {
            sb.append(linha.charAt(i));
        }

        return sb.toString();
    }

}