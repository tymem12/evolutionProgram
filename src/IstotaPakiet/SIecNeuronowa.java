package IstotaPakiet;

import ActionPakiet.AkcjaNeuron;
import GenomPak.Gen;
import GenomPak.Genom;
import NeuronPakiet.NeuronWenetrzny;
import PakietOrganizacyjny.Dane;
import SensorPakiet.SensorNeuron;

import java.io.Serializable;
import java.util.ArrayList;

public class SIecNeuronowa implements Serializable {
    private Genom genomPierwotny;
    private Genom genomRzeczywisty;
    private OrganizatorSieci OS;
    private ArrayList<SensorNeuron> ZbiorSensorow;
    private ArrayList<AkcjaNeuron> zbioryAkcji;
    private ArrayList<NeuronWenetrzny> ZbiorNeuronow;


    public SIecNeuronowa(Genom genom, Dane dane) {

        genomPierwotny = genom;
        OS = new OrganizatorSieci(genom, dane);
        StworzSiec(OS.getRzeczywistyGenom());
        this.genomRzeczywisty = OS.getRzeczywistyGenom();
        }

    public void StworzSiec(Genom genom){
        ZbiorSensorow = new ArrayList<SensorNeuron>();
        zbioryAkcji = new ArrayList<AkcjaNeuron>();
        ZbiorNeuronow = new ArrayList<NeuronWenetrzny>();

        for (int i = 0; i < genom.getListaGenow().size(); i++) {
            if (genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof SensorNeuron) {
                if (!genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().isCzyPoliczony()) {
                    genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().setCzyPoliczony(true);
                    ZbiorSensorow.add((SensorNeuron) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel());
                }
            }
            if(genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof AkcjaNeuron){
                if(!genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel().isCzyPoliczony()) {
                    genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel().setCzyPoliczony(true);
                    zbioryAkcji.add((AkcjaNeuron) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel());
                }
            }
            if(genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof NeuronWenetrzny){
                if(!genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().isCzyPoliczony()) {
                ZbiorNeuronow.add((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel());

                    genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().setCzyPoliczony(true);
                }
            }
        }
    }


    public OrganizatorSieci getOS () {
                return OS;
            }

    public void setOS (OrganizatorSieci OS){
                this.OS = OS;
            }

    public Genom getGenomRzeczywisty() {
        return genomRzeczywisty;
    }

    public void setGenomRzeczywisty(Genom genomRzeczywisty) {
        this.genomRzeczywisty = genomRzeczywisty;
    }




    public ArrayList<SensorNeuron> getZbiorSensorow() {
        return ZbiorSensorow;
    }

    public void setZbiorSensorow(ArrayList<SensorNeuron> zbiorSensorow) {
        ZbiorSensorow = zbiorSensorow;
    }



    public ArrayList<AkcjaNeuron> getZbioryAkcji() {
        return zbioryAkcji;
    }

    public void setZbioryAkcji(ArrayList<AkcjaNeuron> zbioryAkcji) {
        this.zbioryAkcji = zbioryAkcji;
    }

    public ArrayList<NeuronWenetrzny> getZbiorNeuronow() {
        return ZbiorNeuronow;
    }

    public void setZbiorNeuronow(ArrayList<NeuronWenetrzny> zbiorNeuronow) {
        ZbiorNeuronow = zbiorNeuronow;
    }


    public Genom getGenomPierwotny() {
        return genomPierwotny;
    }

    public void setGenomPierwotny(Genom genomPierwotny) {
        this.genomPierwotny = genomPierwotny;
    }

}

