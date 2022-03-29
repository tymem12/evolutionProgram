package ActionPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import NeuronPakiet.Wezel;
import RozmieszczeniePakiet.Operator;

public abstract class AkcjaNeuron extends Wezel {
InterfejsAkcja interfejsAkcja;
double wynik;

public void wykonajRobienie(Istota is) {

    wynik = Math.tanh(pobranyWynik);
    double czyZadziala = Losowe.GenerujDoubla();


    if (czyZadziala < wynik) {
        interfejsAkcja.robienie(is, wynik );
    }
}




    @Override
    public void WyslijDalej() {}


    public double getWynik() {
        return wynik;
    }

    public void setWynik(double wynik) {
        this.wynik = wynik;
    }
}



