package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.util.ArrayList;

public interface InterfejsSensoru {

    public void sensorowanie( Istota is, SensorNeuron sensorAktualny);
}
