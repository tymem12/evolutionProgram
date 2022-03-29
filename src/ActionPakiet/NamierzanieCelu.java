package ActionPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class NamierzanieCelu implements InterfejsAkcja, Serializable {


    @Serial
    private static final long serialVersionUID = -3612062382935555791L;

    int CelX =0;
    int CelY =0;
    @Override
    public void robienie(Istota is, double wynik) {

        if(CelX ==0 && CelY ==0){
            CelX = Losowe.LosowaWZakresie(1,128);
            CelY = Losowe.LosowaWZakresie(1,128);
        }

    if(is.getWspolrzednaAktualnaX() == CelX && is.getWspolrzednaAktualnaY() == CelY){
        CelX =  Losowe.LosowaWZakresie(1,128);
        CelY =  Losowe.LosowaWZakresie(1,128);
    }
        is.KierunekNaPole(CelX,CelY);
        is.RuchWKierunku(false);
        is.SprawdzCzyPoleZabija();

    }
}
