package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class wyczuwanieBezpieczenstwa implements InterfejsSensoru, Serializable {


    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        if(!is.getStanAktualny().getMacierzAktualna()[is.getWspolrzednaAktualnaX()][is.getWspolrzednaAktualnaY()].isCzyBezpieczny()){
            sensorAktualny.poinforum();
        }
    }
}
