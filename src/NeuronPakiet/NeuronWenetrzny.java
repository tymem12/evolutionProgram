package NeuronPakiet;



public class NeuronWenetrzny extends Wezel{

    private int PoloczeniaSamZeSobom =0;
    private boolean PoloczonyZSensorem = false;
    private boolean PoloczonyZAkcja = false;
    private int licznik =0;



    public void WyslijDalej() {


        for(int i =0; i<this.getListaPoloczonych().size(); i++) {
            if (this.getListaPoloczonych().get(i).equals(this)) {

                if (licznik<PoloczeniaSamZeSobom && licznikWejsciowy !=0) {
                    licznik ++;
                    getListaPoloczonych().get(i).Odbierz(Math.tanh(pobranyWynik)*wagiPoloczenia.get(i));
                }

            }
        }
        if (licznikWejsciowy == this.getLiczbaWejsc()) {
            for(int i=0; i<this.getListaPoloczonych().size(); i++){
                if (!this.getListaPoloczonych().get(i).equals(this)) {
                    getListaPoloczonych().get(i).Odbierz(Math.tanh(pobranyWynik) * wagiPoloczenia.get(i));

                }
            }
            licznikWejsciowy +=1;
            pobranyWynik = 0;
        }
        
    }
    public String toString(){
        return "Neuron Wewnetzny";
    }

    public boolean isPoloczonyZSensorem() {
        return PoloczonyZSensorem;
    }

    public void setPoloczonyZSensorem(boolean poloczonyZSensorem) {
        PoloczonyZSensorem = poloczonyZSensorem;
    }

    public boolean isPoloczonyZAkcja() {
        return PoloczonyZAkcja;
    }

    public void setPoloczonyZAkcja(boolean poloczonyZAkcja) {
        PoloczonyZAkcja = poloczonyZAkcja;
    }


    public int getPoloczeniaSamZeSobom() {
        return PoloczeniaSamZeSobom;
    }

    public void setPoloczeniaSamZeSobom(int poloczeniaSamZeSobom) {
        PoloczeniaSamZeSobom = poloczeniaSamZeSobom;
    }

    public int getLicznik() {
        return licznik;
    }

    public void setLicznik(int licznik) {
        this.licznik = licznik;
    }
}
