package SensorPakiet;

public class  SensorPrzeszkody extends SensorNeuron{
    public SensorPrzeszkody(){
        interfejsSensoru = new WyczuwaniePrzeszkody();
    }

    public String toString(){
        return "Sensor Przeszkody";
    }
}
