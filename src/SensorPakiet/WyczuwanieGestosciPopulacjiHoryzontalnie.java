package SensorPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGestosciPopulacjiHoryzontalnie implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {

        double LiczbaNaS =0;
        double LiczbaNaN =0;
        for(int i =0; i<is.getStanAktualny().getWszystkieIstoty().size(); i++){
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() < is.getWspolrzednaAktualnaY()){
                LiczbaNaN++;
            }
            else if(is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() > is.getWspolrzednaAktualnaY()){

                LiczbaNaS++;
            }
        }
        if(LiczbaNaN > 0.75* is.getStanAktualny().getWszystkieIstoty().size() ||
                LiczbaNaS> 0.75*is.getStanAktualny().getWszystkieIstoty().size()) {
            if ((double) LiczbaNaN / (is.getWspolrzednaAktualnaY() * 128) > (double) LiczbaNaS / ((129 - is.getWspolrzednaAktualnaY()) * 128)) {
                is.setKierunek(Kierunek.N);
            } else {
                is.setKierunek(Kierunek.S);
            }
            sensorAktualny.poinforum();
        }



    }
}