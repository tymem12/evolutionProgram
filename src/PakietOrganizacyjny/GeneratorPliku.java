
package PakietOrganizacyjny;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GeneratorPliku {

    public void DokonajAnalizy(ArrayList<String> listaPoloczen, Dane dane) {
        ArrayList<String> posortowana = PosortujWystepowaniem(listaPoloczen);
        NapiszWPliku(posortowana, dane);
    }
    public ArrayList<String> PosortujWystepowaniem(ArrayList<String> listaPoloczen){


        Map<String, Integer> mapa = new HashMap<>();
        ArrayList<String> wyjsciowaTablica = new ArrayList<>();


        for (String aktualnyElement : listaPoloczen) {
            int licznikWystopien = mapa.getOrDefault(aktualnyElement, 0);
            mapa.put(aktualnyElement, licznikWystopien + 1);
            wyjsciowaTablica.add(aktualnyElement);
        }


        SortComparator comp = new SortComparator(mapa);
        Collections.sort(wyjsciowaTablica, comp);

        return wyjsciowaTablica;

    }
    public void NapiszWPliku(ArrayList<String> wyjsciowaTablica, Dane dane){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Nazwij i Zapisz Plik");
        chooser.setCurrentDirectory(new File("C:/Users/tymek/OneDrive/Pulpit/important rzeczy/Program Ewolucja Zdjęcia/Pliki_Po_Analizie"));
        int userSelection = chooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {

            int licznik = 1;

            try {
                File wybranyPlik = chooser.getSelectedFile();
                FileWriter pisarz = new FileWriter(wybranyPlik);
                pisarz.write("PARAMETRY: \n Wielkość populacji: \t" + dane.getPopulacja()+ "\n Wielkość genomu: \t" + dane.getLiczbaGenow()+"" +
                        "\n Liczba neuronów wewnętrznych: \t"+ dane.getLiczbaNeuronow()+ "\n Liczba cykli w generacji: \t" + dane.getLiczbaCykli() +
                        "\n Numer Generacji: \t" + dane.getNumerGeneracji()+ "\n Indeks warunku: \t"+ dane.getIndeksWarunku()
                        + "\n Indeks bariery: \t"+ dane.getIndeksBariery()+ "\n\n\n");

                while (wyjsciowaTablica.size() > 1) {
                    if (wyjsciowaTablica.get(0).equals(wyjsciowaTablica.get(1))){
                        wyjsciowaTablica.remove(1);
                        licznik++;
                    } else {
                        pisarz.write(wyjsciowaTablica.get(0) + " występował  " + licznik + " razy\n ");
                        wyjsciowaTablica.remove(0);
                        licznik = 1;

                    }
                }

                pisarz.write(wyjsciowaTablica.get(0) + " występował  " + licznik + "razy\n ");
               wyjsciowaTablica.remove(0);
                licznik = 1;

                pisarz.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
    class SortComparator implements Comparator<String> {
        private final Map<String , Integer> mapaZWystepowaniem;

        SortComparator(Map<String, Integer> tFreqMap) {
            this.mapaZWystepowaniem = tFreqMap;
        }

        @Override
        public int compare(String k1, String  k2) {

            int porownanieCzestotliwosci = mapaZWystepowaniem.get(k2).compareTo(mapaZWystepowaniem.get(k1));

            int wartosc = k1.compareTo(k2);

            if (porownanieCzestotliwosci == 0)
                return wartosc;
            else
                return porownanieCzestotliwosci;
        }
    }












