package SensorPakiet;

public class SensorGestosciPopWertykalnie extends SensorNeuron{
    public SensorGestosciPopWertykalnie(){
        interfejsSensoru = new WyczuwanieGestośćPopulacjiWertykalnie();
    }
    public String toString(){
        return "Sensor Gestosci Populacji Wertykalnie";
    }
}
