package NeuronPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;
import SensorPakiet.SensorNeuron;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class Wezel implements Serializable, Cloneable {


    @Serial
    private static final long serialVersionUID = 2909305481108806011L;

    private ArrayList<Wezel> listaPoloczonych;
   protected ArrayList<Double> wagiPoloczenia = new ArrayList<Double>();
    private int ileUzyty;

    private int liczbaWejsc =0;
    private int liczbaWyjsc =0;
    private Operator operator;
    protected double pobranyWynik =0;

    private boolean CzyPoliczony = false;
    protected int licznikWejsciowy=0;


    public Wezel(){
        listaPoloczonych = new ArrayList<Wezel>();

    }




    public  void Odbierz(double wynik){
        if(wynik!=0) {
            pobranyWynik = pobranyWynik + (wynik);
            licznikWejsciowy +=1;
        }
    }

    public abstract void WyslijDalej() ;

    public int getLiczbaWejsc() {
        return liczbaWejsc;
    }

    public void setLiczbaWejsc(int liczbaWejsc) {
        this.liczbaWejsc = liczbaWejsc;
    }

    public int getLiczbaWyjsc() {
        return liczbaWyjsc;
    }

    public void setLiczbaWyjsc(int liczbaWyjsc) {
        this.liczbaWyjsc = liczbaWyjsc;
    }
    public int getIleUzyty() {
        return ileUzyty;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setIleUzyty(int ileUzyty) {
        this.ileUzyty = ileUzyty;

}

    public ArrayList<Wezel> getListaPoloczonych() {
        return listaPoloczonych;
    }

    public void setListaPoloczonych(ArrayList<Wezel> listaPoloczonych) {
        this.listaPoloczonych = listaPoloczonych;
    }

    public double getPobranyWynik() {
        return pobranyWynik;
    }

    public void setPobranyWynik(double pobranyWynik) {
        this.pobranyWynik = pobranyWynik;
    }

    public boolean isCzyPoliczony() {
        return CzyPoliczony;
    }

    public void setCzyPoliczony(boolean czyPoliczony) {
        CzyPoliczony = czyPoliczony;
    }

    public ArrayList<Double> getWagiPoloczenia() {
        return wagiPoloczenia;
    }

    public void setWagiPoloczenia(ArrayList<Double> wagiPoloczenia) {
        this.wagiPoloczenia = wagiPoloczenia;
    }

    public int getLicznikWejsciowy() {
        return licznikWejsciowy;
    }

    public void setLicznikWejsciowy(int licznikWejsciowy) {
        this.licznikWejsciowy = licznikWejsciowy;
    }
}

