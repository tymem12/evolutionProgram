package RozmieszczeniePakiet;

import ActionPakiet.AkcjaZabojstwo;
import GenomPak.Genom;
import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import PakietOrganizacyjny.Dane;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.spi.LocaleServiceProvider;

public class Operator implements Serializable {


    @Serial
    private static final long serialVersionUID = -673149628037523171L;

    private ArrayList<Istota> WszystkieIstoty;
    private Punkt[][] MacierzAktualna;

    private WarunkiPrzezycia warunek;
    private Bariera bariera;
    private int LiczbaZabitych;



    public Operator(Dane dane) {
        PrzygotujSrodowisko(dane);
        for (int i = 0; i < dane.getPopulacja(); i++) {
            WszystkieIstoty.add( new Istota(dane));
            wylosujWspolrzedne( WszystkieIstoty.get(i));
        }
        UstanowStan();


    }
    public Operator(Dane dane, ArrayList<Genom> listaGenomow){
        PrzygotujSrodowisko(dane);
        for (int i = 0; i < dane.getPopulacja(); i++) {
            WszystkieIstoty.add( new Istota(listaGenomow.get(i), dane));
            wylosujWspolrzedne( WszystkieIstoty.get(i));
        }
        UstanowStan();
        }

    public void UstanowStan(){
        for(int i= 0; i<WszystkieIstoty.size(); i++) {
            WszystkieIstoty.get(i).setStanAktualny(this);
        }
    }
    public void PrzygotujSrodowisko(Dane dane){
        if(Losowe.zawieraTakiSensor(dane.getWystepujaceAkcje(), AkcjaZabojstwo.class)) LiczbaZabitych = 0;
        WszystkieIstoty = new ArrayList<Istota>();
        MacierzAktualna = new Punkt[130][130];
        for (int i = 0; i < 130; i++) {
            for (int j = 0; j < 130; j++) {
                MacierzAktualna[i][j] = new Punkt();
                if(i == 0 || i == 129 || j == 0 || j==129){
                    MacierzAktualna[i][j].setCzyPreszkoda(true);
                }
            }
        }
        PrzygotujWarunek(dane.getIndeksWarunku());
        PrzygotujBariere(dane.getIndeksBariery());
    }


    public void ZweryfiukujMartwe(){
        for(int i = 0; i<getWszystkieIstoty().size(); i++){
            if(!getMacierzAktualna()[WszystkieIstoty.get(i).getWspolrzednaAktualnaX()][WszystkieIstoty.get(i).getWspolrzednaAktualnaY()].isCzyBezpieczny()){
                WszystkieIstoty.get(i).setCzyZywa(false);
            }
            else WszystkieIstoty.get(i).setCzyZywa(true);
        }


    }
    public void PrzygotujBariere(int indeks){
        switch(indeks) {
            case 0: {
                bariera = Bariera.BRAK_BARIERY;
                break;
            }
            case 1: {
                bariera = Bariera.BARIERA_POLOWA_SRODEK;
                int i = 64;
                for (int z = 1; z <= 128; z++) {
                    if(z<=42 || z>=86) {
                        getMacierzAktualna()[i][z].setCzyPreszkoda(true);
                        getMacierzAktualna()[i+1][z].setCzyPreszkoda(true);
                    }

                }
                break;
            }
            case 2: {
                bariera = Bariera.BARIERA_POLOWA_GRANICA;
                int i = 64;
                for (int z = 1; z <= 128; z++) {
                    if (z >= 32 && z<= 96){
                        getMacierzAktualna()[i][z].setCzyPreszkoda(true);
                        getMacierzAktualna()[i+1][z].setCzyPreszkoda(true);

                    }
                }


                break;
            }
            case 3: {
                bariera = Bariera.PRAWA_NIEBEZPIECZNA;
                int i = 128;
                for (int z = 1; z <= 128; z++) {

                    getMacierzAktualna()[i][z].setCzyZabija(true);

                }
                break;
            }

        }

    }
    public void PrzygotujWarunek(int Ideks){
        switch(Ideks){
            case 0:{
                warunek = WarunkiPrzezycia.OKRAG_SRODKOWY;
                for(int z = 32; z < 96; z++){
                    for(int o = 32; o < 96; o++){
                        getMacierzAktualna()[z][o].setCzyBezpieczny(true);
                    }

                }
                break;
            }
            case 1:{
                warunek = WarunkiPrzezycia.PRAWA_POLOWA;
                for(int z = 1; z <= 128; z++){
                    for(int o = 65; o <= 128; o++){
                        getMacierzAktualna()[o][z].setCzyBezpieczny(true);
                    }

                }
                break;
            }
            case 2:{
                warunek = WarunkiPrzezycia.GORNA_POLOWA;
                for(int z = 1; z <= 128; z++){
                    for(int o = 1; o <= 65; o++){
                        getMacierzAktualna()[z][o].setCzyBezpieczny(true);
                    }

                }
                break;
            }
            case 3:{
                warunek = WarunkiPrzezycia.ROGI_SRODOWISKA;
                for(int z = 1; z <= 128; z++){
                    for(int o = 1; o <= 128; o++) {
                        if(z<=33 && o<= 33 || z<=33 && o>= 96 || o>=96 && z>= 96 || o<=33 && z>= 96)
                        getMacierzAktualna()[z][o].setCzyBezpieczny(true);


                    }
                }
                break;
            }
            case 4:{
                warunek = WarunkiPrzezycia.PRZY_SCIANIE;
                int i =1;
                int j = 128;
                for(int z = 1; z <= 128; z++){
                    getMacierzAktualna()[z][i].setCzyBezpieczny(true);
                    getMacierzAktualna()[z][j].setCzyBezpieczny(true);
                    getMacierzAktualna()[i][z].setCzyBezpieczny(true);
                    getMacierzAktualna()[j][z].setCzyBezpieczny(true);

                }
                break;

            }
            case 5:{
                warunek = WarunkiPrzezycia.BLISKO_SCIANY;
                for(int z = 1; z <= 16; z++){
                    for(int o = 1; o <= 128; o++) {
                        getMacierzAktualna()[z][o].setCzyBezpieczny(true);
                        getMacierzAktualna()[129-z][o].setCzyBezpieczny(true);

                    }
                }
                break;
            }
            case 6:{
                warunek = WarunkiPrzezycia.ODSTEPY;
                for(int z = 1; z <= 128; z++){
                    for(int o = 1; o <= 128; o++) {
                        getMacierzAktualna()[z][o].setCzyBezpieczny(true);

                    }
                    z=z+3;
                }
            }
        }


    }
    public boolean SprawdzDostepnoscAktualna(int x, int y) {
        if (MacierzAktualna[x][y].isZajeta() || MacierzAktualna[x][y].isCzyPreszkoda() || MacierzAktualna[x][y].isCzyZabija()) {
            return true;
        } else {
            return false;
        }

    }
    public void UsunMartwe(){
        for(int i =0; i<WszystkieIstoty.size();i++){
            if(!WszystkieIstoty.get(i).isCzyZywa()){
                WszystkieIstoty.remove(WszystkieIstoty.get(i));
                i--;
            }
        }

    }

    public void wylosujWspolrzedne(Istota is) {
        boolean czyPowtarzac = true;
        while (czyPowtarzac) {
            int x = Losowe.LosowaWZakresie(1, 128);
            int y = Losowe.LosowaWZakresie(1, 128);
            is.setWspolrzednaAktualnaX(x);
            is.setWspolrzednaAktualnaY(y);
            czyPowtarzac = SprawdzDostepnoscAktualna(x, y);
        }
        MacierzAktualna[is.getWspolrzednaAktualnaX()][is.getWspolrzednaAktualnaY()].setZajeta(true);

    }

    public ArrayList<Istota> getWszystkieIstoty() {
        return WszystkieIstoty;
    }

    public void setWszystkieIstoty(ArrayList<Istota> wszystkieIstoty) {
        WszystkieIstoty = wszystkieIstoty;
    }

    public Punkt[][] getMacierzAktualna() {
        return MacierzAktualna;
    }

    public void setMacierzAktualna(Punkt[][] macierzAktualna) {
        MacierzAktualna = macierzAktualna;
    }

    public WarunkiPrzezycia getWarunek() {
        return warunek;
    }

    public void setWarunek(WarunkiPrzezycia warunek) {
        this.warunek = warunek;
    }

    public int getLiczbaZabitych() {
        return LiczbaZabitych;
    }

    public void setLiczbaZabitych(int liczbaZabitych) {
        LiczbaZabitych = liczbaZabitych;
    }

    public Bariera getBariera() {
        return bariera;
    }

    public void setBariera(Bariera bariera) {
        this.bariera = bariera;
    }
}