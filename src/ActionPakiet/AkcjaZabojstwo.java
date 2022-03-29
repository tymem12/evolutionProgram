package ActionPakiet;

import ActionPakiet.AkcjaNeuron;

public class AkcjaZabojstwo extends AkcjaNeuron {
    public AkcjaZabojstwo(){
        interfejsAkcja = new Zabij();
    }

    public String toString(){
        return "Akcja Zabójstwo";
    }
}
