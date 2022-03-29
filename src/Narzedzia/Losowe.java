package Narzedzia;

import java.util.*;
import java.util.Random;

public class Losowe {

    public static String FormatujTekst(String tekst, int argument){
        String zwracana = String.format(tekst+ "%2d" ,argument);
        return zwracana;
    }

    public static int LosowaWZakresie(int min, int max){
        Random rnd = new Random();
        int value;
        if(max>min){
            value = rnd.nextInt(max-min +1) +min;
        }
        else{
            value = rnd.nextInt(min-max +1) +max;
        }
        return value;
    }

    public static void StworzLosowyGen(Integer[] Tab){
        for(int i =0; i<Tab.length; i++){
            Tab[i] = LosowaWZakresie(0,1);
        }
    }

    public static long ZamianaZDwojNaDziesietny(Integer[] Tab, int indeksPocz, int indeksKon){
        String napisWDwojkowym="";
        Long wartoscWDwojkowym;
        for(int i = indeksPocz; i<= (indeksKon); i++){
            napisWDwojkowym = napisWDwojkowym+Tab[i];

        }
        wartoscWDwojkowym = Long.parseLong(napisWDwojkowym,2);
        return wartoscWDwojkowym;
    }

    public static double ObliczWage(Integer[] lista){
        double waga = ZamianaZDwojNaDziesietny(lista, 17, 31);
        if(lista[16] == 0 ){

            return waga/8192;
        }
        else{
            return -waga/8192;


        }

    }
    public static double GenerujDoubla(){
        return Math.random();
    }

        public static <AkcjaNeuron> boolean zawieraTakiSensor(List<AkcjaNeuron> list, Class<? extends AkcjaNeuron> klasa) {
            for (AkcjaNeuron e : list) {
                if (klasa.isInstance(e)) {
                    return true;
                }
            }
            return false;
        }

}
