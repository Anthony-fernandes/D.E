package br.edu.catolica.pp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class AppConcorrente{


    public static void main(String[] args) {

        String linha;

        try {
            BufferedReader conteudoCSV = new BufferedReader(new FileReader("C:\\Users\\55839\\Desktop\\datasetCasas - datasetCasas.csv"));
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
            D_E_Th calcularDE1 = new D_E_Th(0, 1013,info);
            calcularDE1.start();
            D_E_Th calcularDE2 = new D_E_Th(1013, 2027,info);
            calcularDE2.start();
            D_E_Th calcularDE3 = new D_E_Th(2027, 3040,info);
            calcularDE3.start();
            D_E_Th calcularDE4 = new D_E_Th(3040, 4053,info);
            calcularDE4.start();
            D_E_Th calcularDE5 = new D_E_Th(4053, 5067,info);
            calcularDE5.start();
            D_E_Th calcularDE6 = new D_E_Th(5067, 6080,info);
            calcularDE6.start();

            D_E_Th.newBarrier.await();

            D_E_Th calcularDE7 = new D_E_Th();
            calcularDE7.start();

        }catch (IOException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
