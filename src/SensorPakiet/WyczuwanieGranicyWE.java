package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGranicyWE implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        int x = is.getWspolrzednaAktualnaX();

            if(x-is.getZasiegWyczuwania()<=0 || x+is.getZasiegWyczuwania()>=129){
                sensorAktualny.poinforum();
        }
    }
}
