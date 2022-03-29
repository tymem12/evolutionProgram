package ActionPakiet;

public class AkcjaCel extends AkcjaNeuron{
    public AkcjaCel(){
        interfejsAkcja = new NamierzanieCelu();
    }
    public String toString(){
        return "Akcja Cel";
    }
}

