package PakietOrganizacyjny;

import ActionPakiet.*;
import SensorPakiet.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Dane implements Serializable {
    @Serial
    private static final long serialVersionUID = 8085122435043407488L;
    
    private ArrayList<SensorNeuron> wystepujaceSensory;
    private ArrayList<AkcjaNeuron> wystepujaceAkcje;

    private int liczbaNeuronow;
    private int populacja;
    private int liczbaGenow;
    private int liczbaCykli;
    private int indeksWarunku;
    private int indeksBariery;
    private int numerGeneracji;


    public Dane(ArrayList<Boolean> wystepujaceJakieSensory, ArrayList<Boolean> wystepujaceJakieAkcje,
                int liczbaNeuronow, int populacja, int liczbaGenow, int liczbaCykli) {
        
        this.liczbaNeuronow = liczbaNeuronow;
        this.populacja = populacja;
        this.liczbaGenow = liczbaGenow;
        this.liczbaCykli = liczbaCykli;

        PrzygotujListeSensorow(wystepujaceJakieSensory);
        PrzygotujListeAkcji(wystepujaceJakieAkcje);

    }
    public Dane(){

    }
    public void PrzygotujListeSensorow(ArrayList<Boolean> listaS){
        wystepujaceSensory = new ArrayList<SensorNeuron>();

        for(int i =0; i<listaS.size() ; i++){
            if (listaS.get(i)) {
                if (i == 0) wystepujaceSensory.add(new SensorFeromonu());
                else if (i == 1) wystepujaceSensory.add(new SensorGestosciPopHoryzontalnie());
                else if( i==2) wystepujaceSensory.add(new SensorGestosciPopWertykalnie());
                else if( i==3) wystepujaceSensory.add(new SensorGestosciPopulacji());
                else if( i==4) wystepujaceSensory.add(new SensorGranicyNS());
                else if( i==5) wystepujaceSensory.add(new SensorGranicyWE());
                else if( i==6) wystepujaceSensory.add(new SensorNajblizszejBariery());
                else if( i==7) wystepujaceSensory.add(new SensorIstoty());
                else if( i==8) wystepujaceSensory.add(new SensorKierunekNS());
                else if( i==9) wystepujaceSensory.add(new SensorKierunkuWE());
                else if( i==10) wystepujaceSensory.add(new SensorPrzeszkody());
                else if( i==11) wystepujaceSensory.add(new SensorBezpieczenstwa());
                else if( i==12) wystepujaceSensory.add(new SensorSrodka());
                else if( i==13) wystepujaceSensory.add(new SensorPopulacjiWKierunkuPoruszania());
            }
        }
    }
    public void PrzygotujListeAkcji(ArrayList<Boolean> listaA){
        wystepujaceAkcje = new ArrayList<AkcjaNeuron>();

        for(int i =0; i<listaA.size() ; i++){
            if (listaA.get(i)) {
                if (i == 0) wystepujaceAkcje.add(new AkcjaRuchS());
                else if (i == 1) wystepujaceAkcje.add(new AkcjaRuchLosowy());
                else if( i==2) wystepujaceAkcje.add(new AkcjaRuchNaprzod());
                else if( i==3) wystepujaceAkcje.add(new AkcjaCel());
                else if( i==4) wystepujaceAkcje.add(new AkcjaEmitujFeromon());
                else if( i==5) wystepujaceAkcje.add(new AkcjaReaktywnosci());
                else if( i==6) wystepujaceAkcje.add(new AkcjaRuchE());
                else if( i==7) wystepujaceAkcje.add(new AkcjaRuchN());
                else if( i==8) wystepujaceAkcje.add(new AkcjaRuchW());
                else if( i==9) wystepujaceAkcje.add(new AkcjaRuchWPrzeciwnym());
                else if( i==10) wystepujaceAkcje.add(new AkcjaZasieg());
                else if( i==11) wystepujaceAkcje.add(new AkcjaZabojstwo());

            }
        }
    }

   
    public int getLiczbaNeuronow() {
        return liczbaNeuronow;
    }

    public void setLiczbaNeuronow(int liczbaNeuronow) {
        this.liczbaNeuronow = liczbaNeuronow;
    }

    public int getPopulacja() {
        return populacja;
    }

    public void setPopulacja(int populacja) {
        this.populacja = populacja;
    }

    public int getLiczbaGenow() {
        return liczbaGenow;
    }

    public void setLiczbaGenow(int liczbaGenow) {
        this.liczbaGenow = liczbaGenow;
    }

    public int getLiczbaCykli() {
        return liczbaCykli;
    }

    public void setLiczbaCykli(int liczbaCykli) {
        this.liczbaCykli = liczbaCykli;
    }

    public ArrayList<SensorNeuron> getWystepujaceSensory() {
        return wystepujaceSensory;
    }

    public void setWystepujaceSensory(ArrayList<SensorNeuron> wystepujaceSensory) {
        this.wystepujaceSensory = wystepujaceSensory;
    }

    public ArrayList<AkcjaNeuron> getWystepujaceAkcje() {
        return wystepujaceAkcje;
    }

    public void setWystepujaceAkcje(ArrayList<AkcjaNeuron> wystepujaceAkcje) {
        this.wystepujaceAkcje = wystepujaceAkcje;
    }

    public int getIndeksWarunku() {
        return indeksWarunku;
    }

    public void setIndeksWarunku(int indeksWarunku) {
        this.indeksWarunku = indeksWarunku;
    }

    public int getIndeksBariery() {
        return indeksBariery;
    }

    public void setIndeksBariery(int indeksBariery) {
        this.indeksBariery = indeksBariery;
    }

    public int getNumerGeneracji() {
        return numerGeneracji;
    }

    public void setNumerGeneracji(int numerGeneracji) {
        this.numerGeneracji = numerGeneracji;
    }
}

