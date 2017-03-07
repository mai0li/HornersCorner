/*
 * This code is licensed under WTFPL
 * Author: Pedro Maioli (github.com/mai0li)
 */
package aalgoritmos;

import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("serial")
public class Polinomio extends ArrayList<Integer> {

    public Polinomio(int grau) { //construtor
        for (int i = 0; i <= grau; i++) { //percorre termos
            add(new Random().nextInt(10) + 1); //gera constantes aleatórias
                                               //dos termos do polinômio
        }
    }

    //algoritmo de avaliação por força bruta
    long brute(int x) {
        long tempoInicial = System.currentTimeMillis();
        long valor = 0;
        int exp = size() - 1; //size() retorna o próprio tamanho do objeto.
        //ajustando inicializaçao, obtemos em exp o expoente do maior grau.

        for (int i = 0; i < size(); i++) { //percorre termos
            valor = valor + get(i) * pow(x, exp); //acumula valor do polinômio
            exp--; //decresce expoente
        }
        System.out.println("Resultado bruteforce: " + valor);//valor avaliado 
                // problemas com signed integer em valores insanamente altos!
        long tempoFinal = System.currentTimeMillis();
        return tempoFinal - tempoInicial;//retorna custo em milissegundos
    }

    private long pow(int x, int exp) { //eleva uma base x ao seu expoente exp
        long resultado = 0;
        for (int i = 0; i <= exp; i++) {
            switch (i) {
                case 0:
                    resultado = 1; //qualquer inteiro elevado a zero = 1
                    break;
                case 1:
                    resultado = x; //qualquer inteiro elevado a um = ele mesmo
                    break;
                default:
                    resultado = resultado * x; //x^y
                    break;
            }
        }
        return resultado;
    }

    
    //algoritmo de horner para avaliação do polinômio
    long horner(int x) {
        long tempoInicial = System.currentTimeMillis();
        long valor = get(0); //valor do caso base (primeiro termo do polinômio)

        for (int i = 1; i < size(); i++) { //percorre termos do polinômio
            valor = valor * x + get(i); //lógica de Horner = 
                                        //calcule o termo conforme seu sucessor
        }
        System.out.println("Resultado Horner: " + valor);

        long tempoFinal = System.currentTimeMillis();
        return tempoFinal - tempoInicial; //retorna custo em milissegundos
    }

    public static void main(String[] args) {
        
        
        //casos de teste durante produção do código.
        Polinomio p = new Polinomio(100);
        System.out.println("Custo por brute force: " + p.brute(3) + " ms");
        System.out.println("Custo por horner: " + p.horner(3) + " ms");
    }

}