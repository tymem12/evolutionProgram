package ActionPakiet;

public class AkcjaEmitujFeromon extends AkcjaNeuron{
    public AkcjaEmitujFeromon(){
        interfejsAkcja = new EmitujFeromon();
    }

    public String toString(){
        return "Akcja Feromon";
    }
}
