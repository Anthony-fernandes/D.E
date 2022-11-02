package br.edu.catolica.pp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

import static br.edu.catolica.pp.AppConcorrente.tempoInicial;

public class D_E_Serial {

    private List<Dados> info = new ArrayList();

    private List<Dados> casasSemelhantes = new ArrayList();


    public D_E_Serial(List<Dados> info){
        this.info = info;
    }



    public void calcular_DE(){
        double DE = 0;
        Dados casa1;
        Dados casa2;
        int indiceCasa1 = 0;
        int indiceCasa2 = 0;

        DE = Math.sqrt(Math.pow(info.get(0).area - info.get(1).area, 2) + Math.pow(info.get(0).rooms - info.get(1).rooms, 2) + Math.pow(info.get(0).bathroom - info.get(1).bathroom, 2));


        casa1 = new Dados(info.get(0).area, info.get(0).rooms, info.get(0).bathroom);
        indiceCasa1 = 0;
        casa2 = new Dados(info.get(1).area, info.get(1).rooms, info.get(1).bathroom);
        indiceCasa2 = 1;


        for(int i = 0; i < info.size(); i++){
            for(int j = i+2; j < info.size(); j++){
                float x1 = info.get(i).area;
                float x2 = info.get(j).area;

                float y1 = info.get(i).rooms;
                float y2 = info.get(j).rooms;

                float z1 = info.get(i).bathroom;
                float z2 = info.get(j).bathroom;

                double calculo = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));



                if(calculo < DE){

                    DE = calculo;

                    casa1 = new Dados(info.get(i).area, info.get(i).rooms, info.get(i).bathroom);
                    indiceCasa1 = i;

                    casa2 = new Dados(info.get(j).area, info.get(j).rooms, info.get(j).bathroom);
                    indiceCasa2 = j;



                }

            }
        }
        System.out.println("A Thread " + Thread.currentThread().getId() +"Casas mais parecidas!!" + "\nCasa1: " + casa1 + "\nindice da primeira casa: " + indiceCasa1 + "\nCasa2: " + casa2 + "\nindice da segunda casa: " + indiceCasa2 + "\nDE: " + DE);


        casasSemelhantes.add(new Dados(casa1.area, casa1.rooms, casa1.bathroom));
        casasSemelhantes.add(new Dados(casa2.area, casa2.rooms, casa2.bathroom));

        DE = Math.sqrt(Math.pow(casasSemelhantes.get(0).area - casasSemelhantes.get(1).area, 2) + Math.pow(casasSemelhantes.get(0).rooms - casasSemelhantes.get(1).rooms, 2) + Math.pow(casasSemelhantes.get(0).bathroom - casasSemelhantes.get(1).bathroom, 2));


        casa1 = new Dados(casasSemelhantes.get(0).area, casasSemelhantes.get(0).rooms, casasSemelhantes.get(0).bathroom);

        casa2 = new Dados(casasSemelhantes.get(1).area, casasSemelhantes.get(1).rooms, casasSemelhantes.get(1).bathroom);


        System.out.println("entrou");

        System.out.println(casasSemelhantes.size());

        for(int i = 0; i < casasSemelhantes.size(); i++){
            for(int j = i+2; j < casasSemelhantes.size(); j++){
                float x1 = casasSemelhantes.get(i).area;
                float x2 = casasSemelhantes.get(j).area;

                float y1 = casasSemelhantes.get(i).rooms;
                float y2 = casasSemelhantes.get(j).rooms;

                float z1 = casasSemelhantes.get(i).bathroom;
                float z2 = casasSemelhantes.get(j).bathroom;

                double calculo = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2) + Math.pow(z1 - z2, 2));



                if(calculo < DE){

                    DE = calculo;

                    casa1 = new Dados(casasSemelhantes.get(i).area, casasSemelhantes.get(i).rooms, casasSemelhantes.get(i).bathroom);

                    casa2 = new Dados(casasSemelhantes.get(j).area, casasSemelhantes.get(j).rooms, casasSemelhantes.get(j).bathroom);

                }

            }
        }

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Ultima Thread " + Thread.currentThread().getId() +"Casas mais parecidas!!" + "\nCasa1: " + casa1 + "\nCasa2: " + casa2 + "\nDE: " + DE);

    }


}
