package SensorPakiet;

public class SensorGestosciPopulacji extends SensorNeuron{
    public SensorGestosciPopulacji(){
        interfejsSensoru = new WyczuwanieGestosiPopulacji();
    }

    public String toString(){
        return "Sensor Gęstosci Populacji";
    }
}
