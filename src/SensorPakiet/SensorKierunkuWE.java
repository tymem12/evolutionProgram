package SensorPakiet;

public class SensorKierunkuWE extends SensorNeuron{
    public SensorKierunkuWE(){
        interfejsSensoru = new WyczuwanieLokalizacjiWE();
    }

    public String toString(){
        return "Sensor Kierunku WE";
    }
}
