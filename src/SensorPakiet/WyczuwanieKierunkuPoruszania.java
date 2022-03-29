package SensorPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieKierunkuPoruszania implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie(Istota is, SensorNeuron sensorAktualny) {
        int N =0;
        int NE =0;
        int E =0;
        int SE =0;
        int S =0;
        int WS =0;
        int W =0;
        int WN =0;
        for(int i=0; i < is.getStanAktualny().getWszystkieIstoty().size(); i++){
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.N)
            N++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.EN)
            NE++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.E)
            E++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.SE)
            SE++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.S)
            S++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.WS)
            WS++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.W)
            W++;
            if(is.getStanAktualny().getWszystkieIstoty().get(i).getKierunek() == Kierunek.NW);
            WN++;
        }

        int Max = N;
        Max = Math.max(Max, NE);
        Max = Math.max(Max, E);
        Max = Math.max(Max, SE);
        Max = Math.max(Max, S);
        Max = Math.max(Max, WS);
        Max = Math.max(Max, W);
        Max = Math.max(Max, WN);

        if(Max > (double)is.getStanAktualny().getWszystkieIstoty().size()*0.5) {
            if (Max == N) is.setKierunek(Kierunek.N);
            if (Max == NE) is.setKierunek(Kierunek.EN);
            if (Max == E) is.setKierunek(Kierunek.E);
            if (Max == SE) is.setKierunek(Kierunek.SE);
            if (Max == W) is.setKierunek(Kierunek.W);
            if (Max == WS) is.setKierunek(Kierunek.WS);
            if (Max == WN) is.setKierunek(Kierunek.NW);
            if (Max == S) is.setKierunek(Kierunek.S);

            sensorAktualny.poinforum();
        }

    }
}
