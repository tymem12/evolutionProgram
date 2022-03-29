package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieSrodka implements InterfejsSensoru , Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        int x = is.getWspolrzednaAktualnaX();
        int y = is.getWspolrzednaAktualnaY();

        if (y < 96 && y > 32 && x< 96 && x>32) {
            sensorAktualny.poinforum();
        }
    }
}
