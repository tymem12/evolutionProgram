package SensorPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieGestosiPopulacji implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie(Istota is, SensorNeuron sensorAktualny) {


        double LiczbaNaSE = 0;
        double LiczbaNaEN = 0;
        double LiczbaNaNW = 0;
        double LiczbaNaWS = 0;

        int X = is.getWspolrzednaAktualnaX();
        int Y = is.getWspolrzednaAktualnaY();

        for (int i = 0; i < is.getStanAktualny().getWszystkieIstoty().size(); i++) {
            if (is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() < Y &&
                    is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() < X) {
                LiczbaNaNW++;
            } else if (is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() > Y &
                    is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() < X) {
                LiczbaNaWS++;
            } else if (is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() > Y &&
                    is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() > X) {
                LiczbaNaSE++;
            } else if (is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() < Y &&
                    is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() > X) {
                LiczbaNaEN++;
            }
        }

        double Max = LiczbaNaNW / (X * Y);
        Max = Math.max(Max, LiczbaNaWS / (X * (128 - Y)));
        Max = Math.max(Max, LiczbaNaSE / ((128 - X) * (128 - Y)));
        Max = Math.max(Max, LiczbaNaEN / ((X - 128) * Y));

        if (LiczbaNaEN > is.getStanAktualny().getWszystkieIstoty().size() * 0.38 ||
                LiczbaNaNW > is.getStanAktualny().getWszystkieIstoty().size() * 0.38 ||
                LiczbaNaWS > is.getStanAktualny().getWszystkieIstoty().size() * 0.38 ||
                LiczbaNaSE > is.getStanAktualny().getWszystkieIstoty().size() * 0.38) {
            if (Max == LiczbaNaNW / (X * Y)) {
                is.setKierunek(Kierunek.NW);
            } else if (Max == LiczbaNaWS / (X * (128 - Y))) {
                is.setKierunek(Kierunek.WS);
            } else if (Max == LiczbaNaSE / ((128 - X) * (128 - Y))) {
                is.setKierunek(Kierunek.SE);
            } else if (Max == LiczbaNaEN / ((X - 128) * Y)) {
                is.setKierunek(Kierunek.EN);
            }
            sensorAktualny.poinforum();
        }
    }
}
