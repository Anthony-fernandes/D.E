package br.edu.catolica.pp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

import static br.edu.catolica.pp.AppConcorrente.tempoInicial;

public class AppSerial {

    static long tempoInicial = System.currentTimeMillis();
    public static void main(String[] args) {


        String linha;

        try {
            BufferedReader conteudoCSV = new BufferedReader(new FileReader("C:\\Users\\antho\\Documentos\\datasetCasas - datasetCasas.csv"));
            Scanner input = new Scanner(conteudoCSV.readLine());
            input.nextLine();
            List<Dados> info = new ArrayList();
            while ((linha = conteudoCSV.readLine()) != null) {
                String[] dados = linha.split(";");
                int area = Integer.parseInt(dados[0]);
                int rooms = Integer.parseInt(dados[1]);
                int bathroom = Integer.parseInt(dados[2]);
                info.add(new Dados(area, rooms, bathroom));
            }
            D_E_Serial calcularDE = new D_E_Serial(info);
            calcularDE.calcular_DE();

            long tempoFinal = System.currentTimeMillis();
            System.out.println( "tempo: " + (tempoFinal - tempoInicial) +" milissegundos");

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
