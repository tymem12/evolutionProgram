package ActionPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class RuchN implements InterfejsAkcja, Serializable {
    @Override
    public void robienie(Istota is, double wynik) {

        is.setKierunek(Kierunek.N);
        is.RuchWKierunku(false);
        is.SprawdzCzyPoleZabija();

         }
    }


