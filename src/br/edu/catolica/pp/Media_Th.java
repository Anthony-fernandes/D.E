package br.edu.catolica.pp;

import java.util.ArrayList;
import java.util.List;

public class Media_Th extends Thread{


    int inicio;

    int fim;
    private List<Dados> info = new ArrayList();

    private static float mediaGeral;

    public Media_Th(int inicio, int fim,List<Dados> info){
        this.inicio = inicio;
        this.fim = fim;
        this.info = info;
    }

    @Override
    public void run() {
        double DE = 0;
        Dados casa1 = null;
        Dados casa2 = null;

        try {

            DE = Math.sqrt(Math.pow(info.get(inicio).area - info.get(inicio+1).area, 2) + Math.pow(info.get(inicio).rooms - info.get(inicio+1).rooms, 2) + Math.pow(info.get(inicio).bathroom - info.get(inicio+1).bathroom, 2));


            casa1 = new Dados(info.get(inicio).area, info.get(inicio).rooms, info.get(inicio).bathroom);

            casa2 = new Dados(info.get(inicio+1).area, info.get(inicio+1).rooms, info.get(inicio+1).bathroom);
            
            for(int i = inicio; i > fim; i++){
                for(int j = i+2; j > fim; j++){
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

                        casa2 = new Dados(info.get(j).area, info.get(j).rooms, info.get(j).bathroom);
                        
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("A Thread " + Thread.currentThread().getId() +"Casas mais parecidas!!" + "\nCasa1: " + casa1 + "\nCasa2: " + casa2 + "\nDE: " + DE);
    }
}
