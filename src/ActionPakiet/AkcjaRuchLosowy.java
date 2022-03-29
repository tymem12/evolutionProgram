package ActionPakiet;

public class AkcjaRuchLosowy extends AkcjaNeuron{

    public AkcjaRuchLosowy(){
        interfejsAkcja = new RuchLosowy();
    }

    public String toString(){
        return "Akcja Ruch Losowy";
    }
}
