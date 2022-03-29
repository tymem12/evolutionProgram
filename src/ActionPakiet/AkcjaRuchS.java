package ActionPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;

public class AkcjaRuchS  extends AkcjaNeuron {
    public AkcjaRuchS(){

        interfejsAkcja = new RuchS();
    }
    public String toString(){
        return "Akcja Ruch S";
    }
}
