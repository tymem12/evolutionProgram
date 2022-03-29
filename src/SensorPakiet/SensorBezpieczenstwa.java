package SensorPakiet;

public class SensorBezpieczenstwa extends SensorNeuron{
    public SensorBezpieczenstwa(){
        interfejsSensoru = new wyczuwanieBezpieczenstwa();
    }

    public String toString(){
        return "Sensor Bezpieczeństwa";
    }
}
