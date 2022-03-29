package SensorPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGestośćPopulacjiWertykalnie implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        double LiczbaNaW =0;
        double LiczbaNaE =0;


        for(int i =0; i<is.getStanAktualny().getWszystkieIstoty().size(); i++){
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() < is.getWspolrzednaAktualnaX()){
                LiczbaNaW++;
            }
            else{
                LiczbaNaE++;
            }
        }
        if(LiczbaNaW > 0.75* is.getStanAktualny().getWszystkieIstoty().size() || LiczbaNaE> 0.75*is.getStanAktualny().getWszystkieIstoty().size()) {
            if ((double) LiczbaNaW / (is.getWspolrzednaAktualnaX() * 128) > (double) LiczbaNaE / ((129 - is.getWspolrzednaAktualnaX()) * 128)) {
                is.setKierunek(Kierunek.W);
            } else {
                is.setKierunek(Kierunek.E);
            }
            sensorAktualny.poinforum();
        }

    }
}
