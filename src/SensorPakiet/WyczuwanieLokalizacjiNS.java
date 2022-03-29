package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieLokalizacjiNS implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        int y = is.getWspolrzednaAktualnaY();

        if (y > 96 || y < 32) {
            sensorAktualny.poinforum();
        }
    }
}
