/*
 * This code is licensed under WTFPL
 * Author: Pedro Maioli (github.com/mai0li)
 */
package aalgoritmos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Tester {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException {
        //caminho do arquivo futuramente processado pelo gnuplot
        File dados = new File("/Users/king/dados.dat"); 
        BufferedWriter writer = new BufferedWriter(new FileWriter(dados));

        for (int i = 0; i <= 100000; i += 1000) {
            Polinomio p = new Polinomio(i); //gera polinomios de grau 1000, 
                                            //2000, 3000, ... , 100000
                                            
            //escreve valores em colunas                                
            writer.write(i+"\t"+(int)p.brute(2) + "\t" + (int) p.horner(2));
            writer.newLine(); //divisão de linhas
        }

        writer.flush(); //limpa buffers de memória
        writer.close(); //limpa buffers de memória
    }
}