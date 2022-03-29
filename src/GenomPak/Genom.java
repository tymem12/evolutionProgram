package GenomPak;

import Narzedzia.Losowe;
import RozmieszczeniePakiet.NastepnaGeneracja;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Genom  implements Serializable {

    @Serial
    private static final long serialVersionUID = 4383989515588787989L;

    private ArrayList<Gen> listaGenow;
    private int liczbaGen;
    private ArrayList<Integer[]> listaLiczbGenow;

    public Genom(int liczbaGen){
        this.liczbaGen = liczbaGen;

        listaGenow = new ArrayList<Gen>();
        listaLiczbGenow = new ArrayList<Integer[]>();

        for(int i=0; i<liczbaGen; i++) {

           listaLiczbGenow.add( new Integer[32]);
           Losowe.StworzLosowyGen(listaLiczbGenow.get(i));

           listaGenow.add( new Gen(listaLiczbGenow.get(i)[0], (int) Losowe.ZamianaZDwojNaDziesietny(listaLiczbGenow.get(i),1,7),
                   listaLiczbGenow.get(i)[8], (int) Losowe.ZamianaZDwojNaDziesietny(listaLiczbGenow.get(i),9,15),
                   Losowe.ObliczWage(listaLiczbGenow.get(i))));


            }

    }
    public Genom(NastepnaGeneracja ng){
        ng.StworznNowyGenomDziedziczony();

        listaGenow = (ArrayList<Gen>) ng.ListaGenowNowejGeneracji().clone();
        listaLiczbGenow = (ArrayList<Integer[]>) ng.getAktualnyGenomLiczb().clone();
    }


    public Genom(){
        listaGenow = new ArrayList<Gen>();
        listaLiczbGenow = new ArrayList<Integer[]>();
    }



    public ArrayList<Gen> getListaGenow() {
        return listaGenow;
    }

    public void setListaGenow(ArrayList<Gen> listaGenow) {
        this.listaGenow = listaGenow;
    }

    public ArrayList<Integer[]> getListaLiczbGenow() {
        return listaLiczbGenow;
    }

    public void setListaLiczbGenow(ArrayList<Integer[]> listaLiczbGenow) {
        this.listaLiczbGenow = listaLiczbGenow;
    }

    public int getLICZBAGENOW() {
        return liczbaGen;
    }
/*
    public NastepnaGeneracja getOrganizerGenomu() {
        return OrganizerGenomu;
    }

    public void setOrganizerGenomu(NastepnaGeneracja organizerGenomu) {
        OrganizerGenomu = organizerGenomu;
    }

 */
}
