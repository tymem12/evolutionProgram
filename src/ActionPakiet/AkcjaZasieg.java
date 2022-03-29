package ActionPakiet;

public class AkcjaZasieg extends AkcjaNeuron{
    public AkcjaZasieg(){
        interfejsAkcja = new ZmienZasieg();
    }

    public String toString(){
        return "Akcja Zasięg";
    }
}
