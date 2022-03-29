package ActionPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class ZmianaReaktywnosci implements InterfejsAkcja, Serializable {

    @Override
    public void robienie(Istota is,double wynik) {
        if(wynik>0){
            is.setReaktywnosc(1);
        }else{
            is.setReaktywnosc(0);
        }
    }
}
