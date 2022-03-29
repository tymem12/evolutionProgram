package RozmieszczeniePakiet;

import GenomPak.Gen;
import IstotaPakiet.Istota;
import Narzedzia.Losowe;

import java.io.Serializable;
import java.util.ArrayList;

public class NastepnaGeneracja implements Serializable {
   ArrayList<Istota> listaWszystkichZywych;
    ArrayList<Istota> listaPozostalych;
    ArrayList<Gen> aktualnyGenom = new ArrayList<Gen>();
    ArrayList<Integer[]> aktualnyGenomLiczb = new ArrayList<Integer[]>();
    int LiczbaGenow;

    public NastepnaGeneracja(ArrayList<Istota> listaZywych, int LiczbaGenow){
        this.LiczbaGenow = LiczbaGenow;
        for(int i = 0; i<listaZywych.size();i++) {
            for (int j = 0; j < listaZywych.get(j).getSiecNeuro().getGenomPierwotny().getListaGenow().size(); j++) {
                listaZywych.get(i).getSiecNeuro().getGenomPierwotny().getListaGenow().get(j).setCzyUzyteczny(false);
            }
        }
        listaWszystkichZywych = listaZywych;
        listaPozostalych = (ArrayList<Istota>) listaWszystkichZywych.clone();

    }

    public void StworznNowyGenomDziedziczony(){
        aktualnyGenom.clear();
        aktualnyGenomLiczb.clear();
        ArrayList<Gen>  listaSumowanychGenow = new ArrayList<Gen>();
        ArrayList<Integer[]> listaGenowLiczb = new ArrayList<Integer[]>();

        if(listaPozostalych.size() < 3){
           listaPozostalych = (ArrayList<Istota>) listaWszystkichZywych.clone();

        }
             int losowa1 = Losowe.LosowaWZakresie(0, listaPozostalych.size()-1 );
             Istota istota1 = listaPozostalych.get(losowa1);
             listaPozostalych.remove(losowa1);


             int losowa2 = Losowe.LosowaWZakresie(0, listaPozostalych.size() -1);
             Istota istota2 = listaPozostalych.get(losowa2);
             listaPozostalych.remove(losowa2);

             for (int j = 0; j < LiczbaGenow; j++) {
                 listaSumowanychGenow.add(istota1.getSiecNeuro().getGenomPierwotny().getListaGenow().get(j));
                 listaGenowLiczb.add(istota1.getSiecNeuro().getGenomPierwotny().getListaLiczbGenow().get(j));
                 listaSumowanychGenow.add(istota2.getSiecNeuro().getGenomPierwotny().getListaGenow().get(j));
                 listaGenowLiczb.add(istota2.getSiecNeuro().getGenomPierwotny().getListaLiczbGenow().get(j));
             }
             for(int k =0; k<LiczbaGenow; k++){
                 int indkes =Losowe.LosowaWZakresie(0, listaGenowLiczb.size()-1);
                 Gen tymczasowy;
                 if(Losowe.GenerujDoubla() <= 0.001) {
                     tymczasowy = Mutuj(listaGenowLiczb.get(indkes));
                 }else{
                     tymczasowy = listaSumowanychGenow.get(indkes);
                 }
                 aktualnyGenom.add(tymczasowy);
                 aktualnyGenomLiczb.add(listaGenowLiczb.get(indkes));
                 listaSumowanychGenow.remove(indkes);
                 listaGenowLiczb.remove(indkes);

             }

    }
    public Gen Mutuj(Integer[] gen){


        int indkes = Losowe.LosowaWZakresie(0,31);

        if(gen[indkes] ==0) gen[indkes]=1;
        else if (gen[indkes] ==1) gen[indkes]=0;

        Gen zwrotny = new Gen(gen[0], (int) Losowe.ZamianaZDwojNaDziesietny(gen,1,7),
                gen[8], (int) Losowe.ZamianaZDwojNaDziesietny(gen,9,15),
                (double)Losowe.ObliczWage(gen));

        return zwrotny;
    }
    public ArrayList<Gen> ListaGenowNowejGeneracji(){

    return aktualnyGenom;
    }

    public ArrayList<Integer[]> getAktualnyGenomLiczb() {
        return aktualnyGenomLiczb;
    }

    public void setAktualnyGenomLiczb(ArrayList<Integer[]> aktualnyGenomLiczb) {
        this.aktualnyGenomLiczb = aktualnyGenomLiczb;
    }

}

