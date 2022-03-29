package SensorPakiet;

public class SensorGestosciPopHoryzontalnie extends SensorNeuron{
    public SensorGestosciPopHoryzontalnie(){
        interfejsSensoru = new WyczuwanieGestosciPopulacjiHoryzontalnie();
    }
    public String toString(){
        return "Sensor Gestości Populacji Horyzontalnie";
    }
}
