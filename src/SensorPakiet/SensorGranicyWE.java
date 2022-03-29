package SensorPakiet;

public class SensorGranicyWE extends SensorNeuron{
    public SensorGranicyWE(){
        interfejsSensoru = new WyczuwanieGranicyWE();

    }
    public String toString(){
        return "Sensor Granicy WE";
    }
}
