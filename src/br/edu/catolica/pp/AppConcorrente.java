package br.edu.catolica.pp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppConcorrente{

    public static void main(String[] args) {

        long tempoInicial = System.currentTimeMillis();

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
            Media_Th calcularDE1 = new Media_Th(0, 1013,info);
            calcularDE1.start();
            Media_Th calcularDE2 = new Media_Th(1013, 2027,info);
            calcularDE2.start();
            Media_Th calcularDE3 = new Media_Th(2027, 3040,info);
            calcularDE3.start();
            Media_Th calcularDE4 = new Media_Th(3040, 4053,info);
            calcularDE4.start();
            Media_Th calcularDE5 = new Media_Th(4053, 5067,info);
            calcularDE5.start();
            Media_Th calcularDE6 = new Media_Th(5067, 6080,info);
            calcularDE6.start();
        }catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("o metodo executou em " + (System.currentTimeMillis() - tempoInicial + " milisegundos"));

    }
}
