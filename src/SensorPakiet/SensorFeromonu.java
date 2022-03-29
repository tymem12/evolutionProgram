package SensorPakiet;

public class SensorFeromonu extends SensorNeuron{
 public SensorFeromonu(){
    interfejsSensoru = new WyczuwanieFeromonu();
}

    public String toString(){
        return "Sensor Feromonu";
    }
}
