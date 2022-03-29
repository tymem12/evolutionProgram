package IstotaPakiet;

import GenomPak.Genom;
import Narzedzia.Losowe;
import PakietOrganizacyjny.Dane;
import RozmieszczeniePakiet.Operator;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;


public class Istota implements Serializable {

    @Serial
    private static final long serialVersionUID = -8037470570322070302L;
    
    private Genom genomPrawdziwy;
   private int wspolrzednaAktualnaX;
   private int wspolrzednaAktualnaY;
   private Kierunek kierunek;
   private  SIecNeuronowa SiecNeuro;
   private double Reaktywnosc = 0.5;
   private boolean czyZywa ;
   private int ZasiegWyczuwania =2;
   private int[] Kolor;
   private Operator StanAktualny;


    public Istota( Dane dane){
     Kolor = new int[3];
     Kolor[0] = Losowe.LosowaWZakresie(0,255);
     Kolor[1] = Losowe.LosowaWZakresie(0,255);
     Kolor[2] = Losowe.LosowaWZakresie(0,255);
     czyZywa = true;

     this.SiecNeuro = new SIecNeuronowa(new Genom( dane.getLiczbaGenow()), dane);
     kierunek = Kierunek.CENTRE;
     genomPrawdziwy = SiecNeuro.getOS().getRzeczywistyGenom();

    }

    public Istota(Genom genomekNowy, Dane dane){
        Kolor = new int[3];
        Kolor[0] = Losowe.LosowaWZakresie(0,255);
        Kolor[1] = Losowe.LosowaWZakresie(0,255);
        Kolor[2] = Losowe.LosowaWZakresie(0,255);
        czyZywa = true;
        this.SiecNeuro = new SIecNeuronowa(genomekNowy,dane);
        kierunek = Kierunek.CENTRE;
        genomPrawdziwy = SiecNeuro.getGenomPierwotny();

    }
    public int[] OkreslPolozenieWzgeledmKierunku() {
        int[] wspolrzedne = new int[2];
        wspolrzedne[0] = getWspolrzednaAktualnaX();
        wspolrzedne[1] = getWspolrzednaAktualnaY();
        Kierunek kier = getKierunek();
        switch (kier) {
            case N -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX();
                    wspolrzedne[1] = getWspolrzednaAktualnaY() - 1;
                return wspolrzedne;

            }
            case NW -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() - 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY() - 1;
                return wspolrzedne;

            }
            case W -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() - 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY();
                return wspolrzedne;


            }
            case WS -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() - 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY() + 1;

                return wspolrzedne;
            }
            case S -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX();
                    wspolrzedne[1] = getWspolrzednaAktualnaY() + 1;

                return wspolrzedne;

            }
            case SE -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() + 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY() + 1;

                return wspolrzedne;


            }
            case E -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() + 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY();
                return wspolrzedne;


            }
            case EN -> {
                    wspolrzedne[0] = getWspolrzednaAktualnaX() + 1;
                    wspolrzedne[1] = getWspolrzednaAktualnaY() - 1;

                return wspolrzedne;
            }
        }
        return wspolrzedne;
    }

    public void KierunekNaPole(int x, int y) {
        if (x == getWspolrzednaAktualnaX() && y > getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.S;
        }
        if (x == getWspolrzednaAktualnaX() && y < getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.N;
        }
        if (x > getWspolrzednaAktualnaX() && y == getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.E;
        }
        if (x < getWspolrzednaAktualnaX() && y == getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.W;
        }
        if (x > getWspolrzednaAktualnaX() && y < getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.EN;
        }
        if (x > getWspolrzednaAktualnaX() && y > getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.SE;
        }
        if (x < getWspolrzednaAktualnaX() && y < getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.NW;
        }
        if (x < getWspolrzednaAktualnaX() && y > getWspolrzednaAktualnaY()) {
            kierunek = Kierunek.WS;
        }
    }

    public void RozpocznijSekwencje() {

        Collections.shuffle(SiecNeuro.getZbioryAkcji());


        for (int i = 0; i < SiecNeuro.getZbiorSensorow().size(); i++) {
            SiecNeuro.getZbiorSensorow().get(i).wykonajSensorowanie(this);
        }
        
            if (SiecNeuro.getOS().getLiczbaNeuron_Neuron() == 0) {
                for (int i = 0; i < SiecNeuro.getZbiorNeuronow().size(); i++) {
                    SiecNeuro.getZbiorNeuronow().get(i).WyslijDalej();
                }

            } else {
                for (int j = 0; j < SiecNeuro.getOS().getLiczbaNeuron_Neuron() + 1; j++) {
                    for (int i = 0; i < SiecNeuro.getZbiorNeuronow().size(); i++) {
                        SiecNeuro.getZbiorNeuronow().get(i).WyslijDalej();
                    }
                }
        }

        for (int i = 0; i < SiecNeuro.getZbioryAkcji().size(); i++) {
            SiecNeuro.getZbioryAkcji().get(i).wykonajRobienie(this);
        }

        for (int i = 0; i < SiecNeuro.getZbiorSensorow().size(); i++) {
            SiecNeuro.getZbiorSensorow().get(i).setWejsciowy(0);

        }
        for(int j =0; j<SiecNeuro.getZbiorNeuronow().size(); j++) {
                    SiecNeuro.getZbiorNeuronow().get(j).setLicznikWejsciowy(0);
                    SiecNeuro.getZbiorNeuronow().get(j).setPobranyWynik(0);
                     SiecNeuro.getZbiorNeuronow().get(j).setLicznik(0);
        }
        for(int j =0 ; j<SiecNeuro.getZbioryAkcji().size(); j++){
            SiecNeuro.getZbioryAkcji().get(j).setPobranyWynik(0);

        }
    }

    public void SprawdzCzyPoleZabija() {
        if ( StanAktualny.getMacierzAktualna()[wspolrzednaAktualnaX][wspolrzednaAktualnaY].isCzyZabija()) {
            StanAktualny.getMacierzAktualna()[wspolrzednaAktualnaX][wspolrzednaAktualnaY].setZajeta(false);
            czyZywa = false;
            StanAktualny.getWszystkieIstoty().remove(this);
        }
    }
    public void RuchWKierunku(boolean czyPrzeciwny) {
        int x;
        int y;
        int[] wspolrzedne =OkreslPolozenieWzgeledmKierunku();

        if (!czyPrzeciwny) {

            x = wspolrzedne[0];
            y = wspolrzedne[1];

        } else {
            x = 2 * wspolrzednaAktualnaX - wspolrzedne[0];
            y = 2 * wspolrzednaAktualnaY - wspolrzedne[1];

        }
        if (!(getStanAktualny().getMacierzAktualna()[x][y].isZajeta()) && !(getStanAktualny().getMacierzAktualna()[x][y].isCzyPreszkoda())) {
            getStanAktualny().getMacierzAktualna()[getWspolrzednaAktualnaX()][getWspolrzednaAktualnaY()].setZajeta(false);
            getStanAktualny().getMacierzAktualna()[x][y].setZajeta(true);
            setWspolrzednaAktualnaY(y);
            setWspolrzednaAktualnaX(x);
        }
    }

    public int getWspolrzednaAktualnaX() {
        return wspolrzednaAktualnaX;
    }

    public void setWspolrzednaAktualnaX(int wspolrzednaAktualnaX) {
        this.wspolrzednaAktualnaX = wspolrzednaAktualnaX;
    }

    public int getWspolrzednaAktualnaY() {
        return wspolrzednaAktualnaY;
    }

    public void setWspolrzednaAktualnaY(int wspolrzednaAktualnaY) {
        this.wspolrzednaAktualnaY = wspolrzednaAktualnaY;
    }

    public Kierunek getKierunek() {
        return kierunek;
    }

    public void setKierunek(Kierunek kierunek) {
        this.kierunek = kierunek;
    }

    public SIecNeuronowa getSiecNeuro() {
        return SiecNeuro;
    }

    public void setSiecNeuro(SIecNeuronowa siecNeuro) {
        SiecNeuro = siecNeuro;
    }

    public double getReaktywnosc() {
        return Reaktywnosc;
    }

    public void setReaktywnosc(double reaktywnosc) {
        Reaktywnosc = reaktywnosc;
    }

    public Genom getGenomPrawdziwy() {
        return genomPrawdziwy;
    }

    public void setGenomPrawdziwy(Genom genomPrawdziwy) {
        this.genomPrawdziwy = genomPrawdziwy;
    }

    public boolean isCzyZywa() {
        return czyZywa;
    }

    public void setCzyZywa(boolean czyZywa) {
        this.czyZywa = czyZywa;
    }

    public int getZasiegWyczuwania() {
        return ZasiegWyczuwania;
    }

    public void setZasiegWyczuwania(int zasiegWyczuwania) {
        ZasiegWyczuwania = zasiegWyczuwania;
    }

    public int[] getKolor() {
        return Kolor;
    }

    public void setKolor(int[] kolor) {
        Kolor = kolor;
    }

    public Operator getStanAktualny() {
        return StanAktualny;
    }

    public void setStanAktualny(Operator stanAktualny) {
        StanAktualny = stanAktualny;
    }
}

