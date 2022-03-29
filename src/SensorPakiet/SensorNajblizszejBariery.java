package SensorPakiet;

public class SensorNajblizszejBariery extends SensorNeuron{

    public SensorNajblizszejBariery(){
        interfejsSensoru = new WyczuwanieGranicy();
    }

    public String toString(){
        return "Sensor Najbliższej Bariery";
    }
}
