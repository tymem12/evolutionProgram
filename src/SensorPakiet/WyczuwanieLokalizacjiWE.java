package SensorPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieLokalizacjiWE implements InterfejsSensoru, Serializable {

    public void sensorowanie(Istota is, SensorNeuron sensorAktualny) {
        //ouble wejsciowy;
        int x = is.getWspolrzednaAktualnaX();

        if (x > 96 || x < 32) {
            sensorAktualny.poinforum();
        }


        }



}








