package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import javax.crypto.Mac;
import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwaniePrzeszkody implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
       int[] wspolrzedne = is.OkreslPolozenieWzgeledmKierunku();
       int czyZajetaX = wspolrzedne[0];
       int czyZajetaY = wspolrzedne[1];
       if(czyZajetaX != is.getWspolrzednaAktualnaX() && czyZajetaY != is.getWspolrzednaAktualnaY()) {
           if (is.getStanAktualny().getMacierzAktualna()[czyZajetaX][czyZajetaY].isZajeta() ||
                   is.getStanAktualny().getMacierzAktualna()[czyZajetaX][czyZajetaY].isCzyPreszkoda()) {
               is.KierunekNaPole(2 * is.getWspolrzednaAktualnaX() - czyZajetaX, 2 * is.getWspolrzednaAktualnaY() - czyZajetaY);
               sensorAktualny.poinforum();

           }

       }
    }
}
