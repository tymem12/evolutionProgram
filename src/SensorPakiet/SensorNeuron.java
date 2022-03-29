package SensorPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import NeuronPakiet.Wezel;

import java.util.ArrayList;

public abstract class SensorNeuron extends Wezel {
    InterfejsSensoru interfejsSensoru;
    private double wejsciowy;
    private Istota taIstota;


    public void wykonajSensorowanie(Istota is) {
       taIstota = is;
       interfejsSensoru.sensorowanie( is, this);

    }


    public void poinforum() {
        for (int i = 0; i < this.getListaPoloczonych().size(); i++) {
            wejsciowy = (taIstota.getReaktywnosc() + Losowe.GenerujDoubla()) * this.getWagiPoloczenia().get(i);
            this.getListaPoloczonych().get(i).Odbierz(wejsciowy);
        }
    }

    public void SprawdzPozaZakres(int x, int y, Istota is, int mnoznik){
        for(int i =0; i<8; i++) {
            if (x - is.getZasiegWyczuwania()*mnoznik < 0 || x + is.getZasiegWyczuwania()*mnoznik > 129 ||
                    y - is.getZasiegWyczuwania()*mnoznik < 0 || y + is.getZasiegWyczuwania()*mnoznik > 129) {
                is.setZasiegWyczuwania(is.getZasiegWyczuwania() - 1);
            }
            else break;
        }
    }

    public void WyslijDalej(){

    }





    public double getWejsciowy() {
        return wejsciowy;
    }

    public void setWejsciowy(double wejsciowy) {
        this.wejsciowy = wejsciowy;
    }

    public ArrayList<Double> getWagiPoloczenia() {
        return wagiPoloczenia;
    }

    public void setWagiPoloczenia(ArrayList<Double> wagiPoloczenia) {
        this.wagiPoloczenia = wagiPoloczenia;
    }
}

