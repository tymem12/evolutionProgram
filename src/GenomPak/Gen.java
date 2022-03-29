package GenomPak;

import NeuronPakiet.Wezel;

import java.io.Serializable;

public class Gen implements Serializable {
    private int typWejsciowy;
    private int wejsciowyWezel;
    private int wyjsciowyWezel;
    private int typWyjsciowy;
    private double waga;
    private boolean czyUzyteczny;
    private Wezel RzeczywistyWejsciowyWezel;
    private Wezel RzeczywistyWyjsciowyWenzel;

    public Gen(int wejsciowyWezel, int typWejsciowy, int wyjsciowyWezel, int typWyjsciowy, double waga) {
        this.wejsciowyWezel = wejsciowyWezel;
        this.typWejsciowy = typWejsciowy;
        this.wyjsciowyWezel = wyjsciowyWezel;
        this.typWyjsciowy = typWyjsciowy;
        this.waga = waga;
        czyUzyteczny = false;
    }
    public String toString(){
        return RzeczywistyWejsciowyWezel + " połączony Z " + RzeczywistyWyjsciowyWenzel;
    }

    public int getWejsciowyWezel() {
        return wejsciowyWezel;
    }

    public void setWejsciowyWezel(int wejsciowyWezel) {
        this.wejsciowyWezel = wejsciowyWezel;
    }

    public int getTypWejsciowy() {
        return typWejsciowy;
    }

    public void setTypWejsciowy(int typWejsciowy) {
        this.typWejsciowy = typWejsciowy;
    }

    public int getWyjsciowyWezel() {
        return wyjsciowyWezel;
    }

    public void setWyjsciowyWezel(int wyjsciowyWezel) {
        this.wyjsciowyWezel = wyjsciowyWezel;
    }

    public int getTypWyjsciowy() {
        return typWyjsciowy;
    }

    public void setTypWyjsciowy(int typWyjsciowy) {
        this.typWyjsciowy = typWyjsciowy;
    }

    public double getWaga() {
        return waga;
    }

    public void setWaga(long waga) {
        this.waga = waga;
    }

    public void setWaga(double waga) {
        this.waga = waga;
    }

    public boolean isCzyUzyteczny() {
        return czyUzyteczny;
    }

    public void setCzyUzyteczny(boolean czyUzyteczny) {
        this.czyUzyteczny = czyUzyteczny;
    }

    public Wezel getRzeczywistyWejsciowyWezel() {
        return RzeczywistyWejsciowyWezel;
    }

    public void setRzeczywistyWejsciowyWezel(Wezel rzeczywistyWejsciowyWezel) {
        RzeczywistyWejsciowyWezel = rzeczywistyWejsciowyWezel;
    }

    public Wezel getRzeczywistyWyjsciowyWenzel() {
        return RzeczywistyWyjsciowyWenzel;
    }

    public void setRzeczywistyWyjsciowyWenzel(Wezel rzeczywistyWyjsciowyWenzel) {
        RzeczywistyWyjsciowyWenzel = rzeczywistyWyjsciowyWenzel;
    }
}
