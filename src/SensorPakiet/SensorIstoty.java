package SensorPakiet;

public class SensorIstoty extends SensorNeuron{
    public SensorIstoty(){
        interfejsSensoru = new WyczuwanieIstoty();
    }

    public String toString(){
        return "Sensor Istoty";
    }
}
