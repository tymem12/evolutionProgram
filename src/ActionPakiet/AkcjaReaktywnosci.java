package ActionPakiet;

public class AkcjaReaktywnosci extends AkcjaNeuron{
    public AkcjaReaktywnosci(){
        interfejsAkcja = new ZmianaReaktywnosci();
    }

    public String toString(){
        return "Akcja Reaktywnosc";
    }
}
