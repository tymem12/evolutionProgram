package PakietOrganizacyjny;

import GUI.Panel_Srodowisko;
import GenomPak.Genom;
import RozmieszczeniePakiet.NastepnaGeneracja;
import RozmieszczeniePakiet.Operator;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ProjektGeneracja implements ActionListener, Serializable {


    @Serial
    private static final long serialVersionUID = -1674528996867250102L;

    private Panel_Srodowisko panelek;
    private Operator operator;
    Timer t;
    NastepnaGeneracja NG;
   private boolean stanSymulacji;
    int k;
    Dane dane;
    private File plikAktualny;
    private String nazwaPliku;
    private boolean czyPlikZapisany;

    public void WczytajPlik(ProjektGeneracja PrG){
        JFileChooser chooser = new JFileChooser();

        chooser.setCurrentDirectory(new File("C:/Users/tymek/OneDrive/Pulpit/important rzeczy/Program Ewolucja Zdjęcia/Pliki_Serializacja"));

        int returnValue = chooser.showOpenDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
        try {
             File fileSelected = chooser.getSelectedFile();

             czyPlikZapisany = true;
             plikAktualny = fileSelected;
             nazwaPliku = fileSelected.getName();

            FileInputStream fileIn = new FileInputStream(fileSelected);

            ObjectInputStream is = new ObjectInputStream(fileIn);


             PrG = (ProjektGeneracja)is.readObject();
            operator = PrG.operator;
            dane= PrG.dane;
            NG = PrG.NG;
            stanSymulacji = PrG.stanSymulacji;

            panelek.setListaIstot(operator.getWszystkieIstoty());
            NamalujWarunek();
            NamalujBariery();
            panelek.setRysowacKropki(true);
            panelek.repaint();


            }catch (IOException | ClassNotFoundException ex){
             ex.printStackTrace();

        }
        czyPlikZapisany = true;
        }else{
            if(!czyPlikZapisany) czyPlikZapisany = false;
        }

    }


    public void NadpiszPlik(){
        try {
            FileOutputStream fileStream = new FileOutputStream(plikAktualny);

            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.flush();
            os.writeObject(this);

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    public void ZapiszPlik(){

        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Nazwij i Zapisz Plik");
        chooser.setCurrentDirectory(new File("C:/Users/tymek/OneDrive/Pulpit/important rzeczy/Program Ewolucja Zdjęcia/Pliki_Serializacja"));
        int userSelection = chooser.showSaveDialog(null);
        if(userSelection == JFileChooser.APPROVE_OPTION) {


            try {
                FileOutputStream fileStream = new FileOutputStream(new File(String.valueOf(chooser.getSelectedFile())));

                 ObjectOutputStream os = new ObjectOutputStream(fileStream);

                 os.writeObject(this);
                 plikAktualny =chooser.getSelectedFile();
                 nazwaPliku = chooser.getSelectedFile().getName();


             }catch(IOException ex){
                ex.printStackTrace();
             }

            czyPlikZapisany = true;
        } else {
            if(!czyPlikZapisany) czyPlikZapisany = false;
        }


    }

    public void GenerujPlik(){
        ArrayList<String> listaGenowStringi = new ArrayList<String>();
        for(int i =0; i< operator.getWszystkieIstoty().size(); i++){
            for(int j =0 ; j<dane.getLiczbaGenow(); j++){
                listaGenowStringi.add(operator.getWszystkieIstoty().get(i).getSiecNeuro().getGenomPierwotny().getListaGenow().get(j).toString());
            }
        }
        new GeneratorPliku().DokonajAnalizy(listaGenowStringi, dane);
    }


    public void PrzygotujGeneracje() {
        Operator operator = new Operator(dane);

        this.operator = operator;

        panelek.setRysowacKropki(false);
        panelek.repaint();

        NamalujWarunek();
        NamalujBariery();
        panelek.setRysowacKropki(true);
        panelek.setListaIstot(operator.getWszystkieIstoty());
        panelek.repaint();

        }
        public double ObliczProcent(){
        operator.ZweryfiukujMartwe();
        int licznik =0;
        for(int i =0; i<operator.getWszystkieIstoty().size(); i++){
            if(operator.getWszystkieIstoty().get(i).isCzyZywa()) licznik++;
        }
        return (double)licznik/(double)dane.getPopulacja();

    }

    public void Zrestartuj(){


        dane.setNumerGeneracji(0);
        operator = null;
        operator = new Operator(dane);

        panelek.setRysowacKropki(false);
        panelek.setWspolrzedne(null);

        FalszujWarunek();
        FalszujBariery();
        panelek.repaint();

    }
    public boolean PrzygotujOperatora() {
        operator.ZweryfiukujMartwe();
        operator.UsunMartwe();
        if (operator.getWszystkieIstoty().size() < 2) {

            JOptionPane.showMessageDialog(panelek, "Nie ma dwóch istot z których możnaby utworzyć nową generację.\n PROSZĘ ZRESTARTOWAĆ PROGRAM", "Brak Sepłnionych warunków ewolucji",
                    JOptionPane.WARNING_MESSAGE);
            FalszujBariery();
            FalszujWarunek();
            panelek.setRysowacKropki(false);
            panelek.repaint();

            return false;

        } else {
            ZapiszGenomyPoprzedniej();
            ArrayList<Genom> listaNowychGenomow = new ArrayList<Genom>();
            for (int i = 0; i < dane.getPopulacja(); i++) {
                Genom genom = new Genom(NG);
                listaNowychGenomow.add(genom);
            }
            this.operator = new Operator(dane, listaNowychGenomow);
            return true;
        }
    }

    public void StworzNowaGeneracje( int ileRazy) {

        for (int j = 1; j < ileRazy; j++) {
            if (PrzygotujOperatora()) {
                System.out.println(j);
            }
            for (int k = 0; k < dane.getLiczbaCykli(); k++) {
                WykonajRuchDlaKazdejIstoty();
                }
            }
        if (PrzygotujOperatora()) {

            NamalujWarunek();
            NamalujBariery();
            panelek.setRysowacKropki(true);
            panelek.setListaIstot(operator.getWszystkieIstoty());
            panelek.repaint();
        }

    }
    public void WykonajRuchDlaKazdejIstoty(){
        for (int i = 0; i < operator.getWszystkieIstoty().size(); i++) {
            operator.getWszystkieIstoty().get(i).RozpocznijSekwencje();
        }
        Collections.shuffle(operator.getWszystkieIstoty());
    }


    public void RopocznijSymulacje() {
        if (k == 0) {
            t = new Timer(30, this);
            t.start();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        WykonajRuchDlaKazdejIstoty();

        panelek.repaint();
        k++;
        if(k>dane.getLiczbaCykli()){
            k=0;
            t.stop();

        }
        System.out.println(k);
    }

    public void NamalujBariery(){
        switch(operator.getBariera()) {
            case BRAK_BARIERY -> {
            FalszujBariery();

             }
            case BARIERA_POLOWA_SRODEK -> {
                 FalszujBariery();
                 panelek.setBarieraBramka(true);
            }
            case BARIERA_POLOWA_GRANICA -> {
                FalszujBariery();
                panelek.setBarieraPrzeszkoda(true);
            }
            case PRAWA_NIEBEZPIECZNA -> {
                FalszujBariery();
                panelek.setBarieraZabojcza(true);
            }
        }
    }
    public void NamalujWarunek(){
        switch(operator.getWarunek()){
            case OKRAG_SRODKOWY -> {
                FalszujWarunek();
                panelek.setSrodkowyOkrogWarunek(true);
            }
            case PRAWA_POLOWA -> {
                FalszujWarunek();
                panelek.setPrawaPolowaWarunek(true);
            }
            case GORNA_POLOWA -> {
                FalszujWarunek();
                panelek.setGornaPolowaWarunek(true);
            }
            case ROGI_SRODOWISKA -> {
                FalszujWarunek();
                panelek.setRogiSrodowiskaWarunek(true);
            }
            case PRZY_SCIANIE -> {
                FalszujWarunek();
                panelek.setPrzyScianieWarunek(true);
            }
            case BLISKO_SCIANY -> {
                FalszujWarunek();
                panelek.setBliskoScianyWarunek(true);
            }
            case ODSTEPY -> {
                FalszujWarunek();
                panelek.setOdstepyWarunek(true);
            }
        }
    }
    public void FalszujBariery(){

        panelek.setBarieraZabojcza(false);
        panelek.setBarieraPrzeszkoda(false);
        panelek.setBarieraBramka(false);

    }
    public void FalszujWarunek(){
        panelek.setPrawaPolowaWarunek(false);
        panelek.setGornaPolowaWarunek(false);
        panelek.setSrodkowyOkrogWarunek(false);
        panelek.setPrzyScianieWarunek(false);
        panelek.setBliskoScianyWarunek(false);
        panelek.setOdstepyWarunek(false);
        panelek.setRogiSrodowiskaWarunek(false);
    }
    public void ZapiszGenomyPoprzedniej(){
        NG = new NastepnaGeneracja(operator.getWszystkieIstoty(),dane.getLiczbaGenow());
    }


    public Panel_Srodowisko getPanelek() {
        return panelek;
    }

    public void setPanelek(Panel_Srodowisko panelek) {
        this.panelek = panelek;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }


    public Dane getDane() {
        return dane;
    }

    public void setDane(Dane dane) {
        this.dane = dane;
    }

    public File getPlikAktualny() {
        return plikAktualny;
    }

    public void setPlikAktualny(File plikAktualny) {
        this.plikAktualny = plikAktualny;
    }

    public boolean isStanSymulacji() {
        return stanSymulacji;
    }

    public void setStanSymulacji(boolean stanSymulacji) {
        this.stanSymulacji = stanSymulacji;
    }

    public String getNazwaPliku() {
        return nazwaPliku;
    }

    public void setNazwaPliku(String nazwaPliku) {
        this.nazwaPliku = nazwaPliku;
    }

    public boolean isCzyPlikZapisany() {
        return czyPlikZapisany;
    }

    public void setCzyPlikZapisany(boolean czyPlikZapisany) {
        this.czyPlikZapisany = czyPlikZapisany;
    }
}




