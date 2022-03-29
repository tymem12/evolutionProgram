package SensorPakiet;

public class SensorGranicyNS extends SensorNeuron{
    public SensorGranicyNS(){
        interfejsSensoru = new WyczuwanieGranicyNS();
    }

    public String toString(){
        return "Sensor Granicy NS";
    }
}
