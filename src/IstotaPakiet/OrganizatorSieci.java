package IstotaPakiet;

import ActionPakiet.*;
import GenomPak.Gen;
import GenomPak.Genom;
import NeuronPakiet.NeuronWenetrzny;
import NeuronPakiet.Wezel;
import PakietOrganizacyjny.Dane;
import SensorPakiet.*;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class OrganizatorSieci implements Serializable {

    private int liczbaNeuron_Neuron =0;
    boolean CzyUruchomicAllgorytm = false;
    ArrayList<SensorNeuron> sensoryTejIstoty;
    ArrayList<AkcjaNeuron> akcjeTejIstoty;
    ArrayList<NeuronWenetrzny> neuronyDoUzytku;

    private Genom RzeczywistyGenom;

    public OrganizatorSieci(Genom genom, Dane dane)  {
        neuronyDoUzytku = new ArrayList<NeuronWenetrzny>();
        RzeczywistyGenom = new Genom();
        for(int i = 0; i< dane.getLiczbaNeuronow(); i++){
            neuronyDoUzytku.add(new NeuronWenetrzny());
        }

        try {
            sensoryTejIstoty = (ArrayList<SensorNeuron>) SklonujWlasnaListe(dane.getWystepujaceSensory());
            akcjeTejIstoty = (ArrayList<AkcjaNeuron>) SklonujWlasnaListe(dane.getWystepujaceAkcje());
        } catch (  InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < genom.getListaGenow().size(); i++) {
            ustawWejsciowySensor(genom.getListaGenow().get(i), sensoryTejIstoty);
            ustawWyjsciowyAkcji(genom.getListaGenow().get(i),akcjeTejIstoty);
        }
        ZweryfikujGenom(genom);
        UsunNiepotrzebne(genom);
        UstanowListePoloczen();
    }


    public <T extends Wezel> ArrayList<T> SklonujWlasnaListe(ArrayList<T> lista) throws  InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            ArrayList<T> Sklonowana = new ArrayList<T>(lista.size());
            for (T element : lista) {

                Constructor<T> konstruktorek = (Constructor<T>) element.getClass().getDeclaredConstructor();
                T obj = (T) konstruktorek.newInstance();

                Sklonowana.add(obj);
            }
            return Sklonowana;

    }

    public void ustawWejsciowySensor(Gen gen, ArrayList<SensorNeuron> lista) {


        if (gen.getWejsciowyWezel() == 0) {
            int wynik = gen.getTypWejsciowy() % lista.size();
            gen.setRzeczywistyWejsciowyWezel(lista.get(wynik));


        } else if (gen.getWejsciowyWezel() == 1) {
            int wynik = gen.getTypWejsciowy() % neuronyDoUzytku.size();
            gen.setRzeczywistyWejsciowyWezel(neuronyDoUzytku.get(wynik));
        }

    }

    public void ustawWyjsciowyAkcji(Gen gen, ArrayList<AkcjaNeuron> lista) {


        if (gen.getWyjsciowyWezel() == 0) {
            int wynik= gen.getTypWyjsciowy() % lista.size();
            gen.setRzeczywistyWyjsciowyWenzel(lista.get(wynik));

        } else if (gen.getWyjsciowyWezel() == 1) {
                int wynik= gen.getTypWyjsciowy() % neuronyDoUzytku.size();
                gen.setRzeczywistyWyjsciowyWenzel(neuronyDoUzytku.get(wynik));

        }

    }

    public void ZweryfikujGenom(Genom genom) {
        for (int i = 0; i < genom.getListaGenow().size(); i++) {
            if (genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof SensorNeuron &&
                    genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof AkcjaNeuron) {
                genom.getListaGenow().get(i).setCzyUzyteczny(true);
            }
            if ((genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof SensorNeuron &&
                    genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof NeuronWenetrzny)) {
                ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()).setPoloczonyZSensorem(true);
                CzyUruchomicAllgorytm = true;


            }
            if ((genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof AkcjaNeuron &&
                    genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof NeuronWenetrzny)) {
                ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).setPoloczonyZAkcja(true);
                CzyUruchomicAllgorytm = true;

            }

        }
        if (CzyUruchomicAllgorytm) {

            for (int j = 0; j < genom.getListaGenow().size(); j++) {

                for (int i = 0; i < genom.getListaGenow().size(); i++) {
                    if (genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof NeuronWenetrzny) {
                        if (genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof NeuronWenetrzny) {

                            if (((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).isPoloczonyZSensorem()) {
                                ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()).setPoloczonyZSensorem(true);
                            }
                            if (((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()).isPoloczonyZAkcja()) {
                                ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).setPoloczonyZAkcja(true);
                            }
                        }
                    }
                }
            }
            SprawdzPoloczenie(genom);
        }
    }

        public void UstanowListePoloczen(){
            for(int i =0; i<RzeczywistyGenom.getListaGenow().size(); i++) {
            RzeczywistyGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().getListaPoloczonych().add(RzeczywistyGenom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel());
                RzeczywistyGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().getWagiPoloczenia().add(RzeczywistyGenom.getListaGenow().get(i).getWaga());

                }
        }



        public void SprawdzPoloczenie(Genom genom){
            for (int i = 0; i < genom.getListaGenow().size(); i++) {


                if (genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof NeuronWenetrzny) {
                    if (((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).isPoloczonyZAkcja() &&
                            ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).isPoloczonyZSensorem()) {
                        genom.getListaGenow().get(i).setCzyUzyteczny(true);
                    }
                }
                if (genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof NeuronWenetrzny) {
                    if (((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()).isPoloczonyZAkcja() &&
                            ((NeuronWenetrzny) genom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()).isPoloczonyZSensorem()) { // ZMIANA
                        genom.getListaGenow().get(i).setCzyUzyteczny(true);
                    }
                }
            }
        }
        public void UsunNiepotrzebne(Genom genom){


            for(int i =0; i<genom.getListaGenow().size(); i++){
               if( genom.getListaGenow().get(i).isCzyUzyteczny()){
                   RzeczywistyGenom.getListaGenow().add(genom.getListaGenow().get(i));
               }
            }
            Policz(RzeczywistyGenom);
        }



    public void Policz(Genom nGenom){
             for(int i =0; i<nGenom.getListaGenow().size(); i++){

                 if(nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel() instanceof NeuronWenetrzny) {
                     if (nGenom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel() instanceof NeuronWenetrzny) {

                         if (nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().getIleUzyty() == 0) {
                             nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().setIleUzyty(nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().getIleUzyty() + 1);
                             liczbaNeuron_Neuron++;
                         }
                         if (nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().equals(nGenom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel()))
                             ((NeuronWenetrzny) nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).setPoloczeniaSamZeSobom(((
                                     NeuronWenetrzny) nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel()).getPoloczeniaSamZeSobom() +1);
                     }
                 }
            nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().setLiczbaWyjsc(nGenom.getListaGenow().get(i).getRzeczywistyWejsciowyWezel().getLiczbaWyjsc() +1);
            nGenom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel().setLiczbaWejsc(nGenom.getListaGenow().get(i).getRzeczywistyWyjsciowyWenzel().getLiczbaWejsc() +1);
            }

        }
    public Genom getRzeczywistyGenom() {
        return RzeczywistyGenom;
    }

    public void setRzeczywistyGenom(Genom rzeczywistyGenom) {
        RzeczywistyGenom = rzeczywistyGenom;
    }

    public int getLiczbaNeuron_Neuron() {
        return liczbaNeuron_Neuron;
    }

    public void setLiczbaNeuron_Neuron(int liczbaNeuron_Neuron) {
        this.liczbaNeuron_Neuron = liczbaNeuron_Neuron;
    }


}






