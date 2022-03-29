package ActionPakiet;

import NeuronPakiet.Wezel;

public class AkcjaRuchWPrzeciwnym extends AkcjaNeuron {
    public AkcjaRuchWPrzeciwnym(){
        interfejsAkcja = new RuchWPrzeciwnym();
    }
    public String toString(){
        return "Akcja Ruch w Przeciwnym";
    }
}
