package ActionPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class RuchWPrzeciwnym implements InterfejsAkcja, Serializable {
    @Override
    public void robienie(Istota is, double wynik) {
        is.RuchWKierunku(true);
        is.SprawdzCzyPoleZabija();
    }
}
