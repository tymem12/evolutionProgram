package SensorPakiet;

public class SensorKierunekNS extends SensorNeuron {
    public SensorKierunekNS (){
        interfejsSensoru = new WyczuwanieLokalizacjiNS();
    }

    public String toString(){
        return "Sensor Kierunek NS";
    }
}
