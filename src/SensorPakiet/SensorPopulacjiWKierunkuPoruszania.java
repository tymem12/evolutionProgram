package SensorPakiet;

public class SensorPopulacjiWKierunkuPoruszania extends SensorNeuron{
   public SensorPopulacjiWKierunkuPoruszania(){
        interfejsSensoru = new WyczuwanieKierunkuPoruszania();
    }

    public String toString(){
        return "Sensor Populacji W Kierunku Poruszania";
    }
}
