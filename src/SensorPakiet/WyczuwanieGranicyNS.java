package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGranicyNS implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {

        int y = is.getWspolrzednaAktualnaY();

            if(y-is.getZasiegWyczuwania()<=0 || y+is.getZasiegWyczuwania()>=129){
                sensorAktualny.poinforum();




        }
    }
}