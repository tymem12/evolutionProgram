package ActionPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class RuchNaprzod implements InterfejsAkcja, Serializable {
    @Override
    public void robienie(Istota is,  double wynik) {

        is.RuchWKierunku(false);
        is.SprawdzCzyPoleZabija();

    }
}
