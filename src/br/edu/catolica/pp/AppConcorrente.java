package br.edu.catolica.pp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;

public class AppConcorrente{

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
            D_E_Th calcularDE1 = new D_E_Th(0, 380,info);
            calcularDE1.start();
            D_E_Th calcularDE2 = new D_E_Th(381, 760,info);
            calcularDE2.start();
            D_E_Th calcularDE3 = new D_E_Th(761, 1140,info);
            calcularDE3.start();
            D_E_Th calcularDE4 = new D_E_Th(1141, 1520,info);
            calcularDE4.start();
            D_E_Th calcularDE5 = new D_E_Th(1521, 1900,info);
            calcularDE5.start();
            D_E_Th calcularDE6 = new D_E_Th(1901, 2280,info);
            calcularDE6.start();
            D_E_Th calcularDE7 = new D_E_Th(2281, 2660,info);
            calcularDE7.start();
            D_E_Th calcularDE8 = new D_E_Th(2661, 3040,info);
            calcularDE8.start();
            D_E_Th calcularDE9 = new D_E_Th(3041, 3420,info);
            calcularDE9.start();
            D_E_Th calcularDE10 = new D_E_Th(3421, 3800,info);
            calcularDE10.start();
            D_E_Th calcularDE11 = new D_E_Th(3801, 4180,info);
            calcularDE11.start();
            D_E_Th calcularDE12 = new D_E_Th(4181, 4560,info);
            calcularDE12.start();
            D_E_Th calcularDE13 = new D_E_Th(4561, 4940,info);
            calcularDE13.start();
            D_E_Th calcularDE14 = new D_E_Th(4941, 5320,info);
            calcularDE14.start();
            D_E_Th calcularDE15 = new D_E_Th(5321, 5700,info);
            calcularDE15.start();
            D_E_Th calcularDE16 = new D_E_Th(5701, 3080,info);
            calcularDE16.start();

//            D_E_Th calcularDE1 = new D_E_Th(0, 1013,info);
//            calcularDE1.start();
//            D_E_Th calcularDE2 = new D_E_Th(1013, 2027,info);
//            calcularDE2.start();
//            D_E_Th calcularDE3 = new D_E_Th(2027, 3040,info);
//            calcularDE3.start();
//            D_E_Th calcularDE4 = new D_E_Th(3040, 4053,info);
//            calcularDE4.start();
//            D_E_Th calcularDE5 = new D_E_Th(4053, 5067,info);
//            calcularDE5.start();
//            D_E_Th calcularDE6 = new D_E_Th(5067, 6080,info);
//            calcularDE6.start();

            D_E_Th.newBarrier.await();

            D_E_Th calcularDE17 = new D_E_Th();
            calcularDE17.start();

        }catch (IOException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
