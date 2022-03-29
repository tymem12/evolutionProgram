package ActionPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class ZmienZasieg implements InterfejsAkcja, Serializable {
    @Override
    public void robienie(Istota is, double wynik) {
        if(wynik>0){
        is.setZasiegWyczuwania(4);
    } else{
            is.setZasiegWyczuwania(1);
        }
    }
}
