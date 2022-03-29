package ActionPakiet;

public class AkcjaRuchNaprzod extends AkcjaNeuron{
    public AkcjaRuchNaprzod(){
        interfejsAkcja = new RuchNaprzod();
    }

    public String toString(){
        return "Akcja Ruch Naprzod";
    }
}
