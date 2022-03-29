package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGranicy implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        int x = is.getWspolrzednaAktualnaX();
        int y = is.getWspolrzednaAktualnaY();

        sensorAktualny.SprawdzPozaZakres(x,y,is,1);

        for(int i = x-is.getZasiegWyczuwania(); i<= x+ is.getZasiegWyczuwania(); i++) {
            for (int j = y - is.getZasiegWyczuwania(); j <= y + is.getZasiegWyczuwania(); j++) {

                if (is.getStanAktualny().getMacierzAktualna()[i][j].isCzyPreszkoda()) {
                    sensorAktualny.poinforum();
                    i= x+ is.getZasiegWyczuwania() +1;
                    j = y + is.getZasiegWyczuwania()+1;

                }



        }
        }
    }
}
