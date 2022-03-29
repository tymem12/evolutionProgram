package GUI;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Punkt;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;


public class Panel_Srodowisko extends JPanel implements Serializable {


    static final int SZEROKOSC_OBRAZU = 780;
    static final int WYSOKOSC_OBRAZU = 780;
    static final int WIELKOSC_KOMORKI = 6;
    @Serial
    private static final long serialVersionUID = -3759765219397137380L;


    private boolean rysowacKropki = false;
    private boolean SrodkowyOkrogWarunek = false;
     private boolean Aktualizuj = false;
     private boolean PrawaPolowaWarunek = false;
     private boolean GornaPolowaWarunek = false;
     private boolean RogiSrodowiskaWarunek = false;
     private boolean PrzyScianieWarunek = false;
     private boolean BliskoScianyWarunek = false;
     private boolean OdstepyWarunek = false;
    private Punkt[][] Wspolrzedne;
    private ArrayList<Istota> listaIstot;
    private boolean BarieraBramka = false;
    private boolean BarieraPrzeszkoda = false;
    private boolean BarieraZabojcza = false;




    public Panel_Srodowisko() {
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        this.setPreferredSize(new java.awt.Dimension(SZEROKOSC_OBRAZU, WYSOKOSC_OBRAZU));

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        for(int k =0; k<130 ; k++){
            g.fillRect(k*WIELKOSC_KOMORKI,0, WIELKOSC_KOMORKI, WIELKOSC_KOMORKI);
            g.fillRect(k*WIELKOSC_KOMORKI,129*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
            g.fillRect(0,k*WIELKOSC_KOMORKI,WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
            g.fillRect(129*WIELKOSC_KOMORKI, k*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
        }
        g.setColor(new Color(230, 247, 199));
        if(SrodkowyOkrogWarunek){

            for(int z = 32; z < 96; z++){
                for(int o = 32; o < 96; o++) {
                    g.fillRect(z*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                }
            }

        }
        if(PrawaPolowaWarunek){
            for(int z = 1; z <= 128; z++) {
                for (int o = 65; o <= 128; o++) {
                    g.fillRect(o*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);

                }
            }
        }
        if(GornaPolowaWarunek){
            for(int z = 1; z <= 128; z++){
                for(int o = 1; o <= 65; o++){
                    g.fillRect(z*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);

                }
            }
        }
        if(RogiSrodowiskaWarunek){
            for(int z = 1; z <= 128; z++){
                for(int o = 1; o <= 128; o++) {
                    if(z<=33 && o<= 33 || z<=33 && o>= 96 || o>=96 && z>= 96 || o<=33 && z>= 96)
                    g.fillRect(z*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                }
            }
        }
        if(PrzyScianieWarunek){
            int k =1;
            int p = 128;
            for(int z = 1; z <= 128; z++){
                g.fillRect(z*WIELKOSC_KOMORKI, k*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                g.fillRect(z*WIELKOSC_KOMORKI, p*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                g.fillRect(k*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                g.fillRect(p*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);

                }

        }
        if(BliskoScianyWarunek) {
            for (int z = 1; z <= 16; z++) {
                for (int o = 1; o <= 128; o++) {
                    g.fillRect(z*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                    g.fillRect((129-z)*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);

                }
            }
        }
        if(OdstepyWarunek) {
            for (int z = 1; z <= 128; z++) {
                for (int o = 1; o <= 128; o++) {
                    g.fillRect(z*WIELKOSC_KOMORKI, o*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                }
                z=z+3;
            }
        }
        if(BarieraBramka){
            g.setColor(Color.BLACK);
            int i = 64;
            for (int z = 1; z <= 128; z++) {
                if(z<=42 || z>=86) {
                    g.fillRect(i*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                    g.fillRect((i+1)*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                }
            }
        }
        if(BarieraPrzeszkoda){
            g.setColor(Color.BLACK);
            int i = 64;
            for (int z = 1; z <= 128; z++) {
                if (z >= 32 && z<= 96){
                    g.fillRect(i*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                    g.fillRect((i+1)*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);
                }
            }
        }
        if(BarieraZabojcza){
            g.setColor(Color.RED);
            int i = 128;
            for (int z = 1; z <= 128; z++) {
                    g.fillRect(i*WIELKOSC_KOMORKI, z*WIELKOSC_KOMORKI, WIELKOSC_KOMORKI,WIELKOSC_KOMORKI);

                }
        }

            if (rysowacKropki) {

                for (int i = 0; i < getListaIstot().size(); i++) {
                    int x = getListaIstot().get(i).getWspolrzednaAktualnaX();
                    int y = getListaIstot().get(i).getWspolrzednaAktualnaY();

                    g.setColor(new Color(getListaIstot().get(i).getKolor()[0], getListaIstot().get(i).getKolor()[1], getListaIstot().get(i).getKolor()[2]));
                    g.fillOval((x ) * WIELKOSC_KOMORKI, (y ) * WIELKOSC_KOMORKI,  WIELKOSC_KOMORKI,  WIELKOSC_KOMORKI);
                }
            }

        }

    public boolean isSrodkowyOkrogWarunek() {
        return SrodkowyOkrogWarunek;
    }

    public void setSrodkowyOkrogWarunek(boolean srodkowyOkrogWarunek) {
        SrodkowyOkrogWarunek = srodkowyOkrogWarunek;
    }

    public boolean isRysowacKropki() {
        return rysowacKropki;
    }

    public void setRysowacKropki(boolean rysowacKropki) {
        this.rysowacKropki = rysowacKropki;

    }

    public Punkt[][] getWspolrzedne() {
        return Wspolrzedne;
    }

    public void setWspolrzedne(Punkt[][] wspolrzedne) {
        Wspolrzedne = wspolrzedne;
    }

    public ArrayList<Istota> getListaIstot() {
        return listaIstot;
    }

    public void setListaIstot(ArrayList<Istota> listaIstot) {
        this.listaIstot = listaIstot;
    }

    public boolean isAktualizuj() {
        return Aktualizuj;
    }

    public void setAktualizuj(boolean aktualizuj) {
        Aktualizuj = aktualizuj;
    }

    public boolean isPrawaPolowaWarunek() {
        return PrawaPolowaWarunek;
    }

    public void setPrawaPolowaWarunek(boolean prawaPolowaWarunek) {
        PrawaPolowaWarunek = prawaPolowaWarunek;
    }

    public boolean isGornaPolowaWarunek() {
        return GornaPolowaWarunek;
    }

    public void setGornaPolowaWarunek(boolean gornaPolowaWarunek) {
        GornaPolowaWarunek = gornaPolowaWarunek;
    }

    public boolean isRogiSrodowiskaWarunek() {
        return RogiSrodowiskaWarunek;
    }

    public void setRogiSrodowiskaWarunek(boolean rogiSrodowiskaWarunek) {
        RogiSrodowiskaWarunek = rogiSrodowiskaWarunek;
    }

    public boolean isPrzyScianieWarunek() {
        return PrzyScianieWarunek;
    }

    public void setPrzyScianieWarunek(boolean przyScianieWarunek) {
        PrzyScianieWarunek = przyScianieWarunek;
    }

    public boolean isBliskoScianyWarunek() {
        return BliskoScianyWarunek;
    }

    public void setBliskoScianyWarunek(boolean bliskoScianyWarunek) {
        BliskoScianyWarunek = bliskoScianyWarunek;
    }

    public boolean isOdstepyWarunek() {
        return OdstepyWarunek;
    }

    public void setOdstepyWarunek(boolean odstepyWarunek) {
        OdstepyWarunek = odstepyWarunek;
    }

    public boolean isBarieraBramka() {
        return BarieraBramka;
    }

    public void setBarieraBramka(boolean barieraBramka) {
        BarieraBramka = barieraBramka;
    }

    public boolean isBarieraPrzeszkoda() {
        return BarieraPrzeszkoda;
    }

    public void setBarieraPrzeszkoda(boolean barieraPrzeszkoda) {
        BarieraPrzeszkoda = barieraPrzeszkoda;
    }

    public boolean isBarieraZabojcza() {
        return BarieraZabojcza;
    }

    public void setBarieraZabojcza(boolean barieraZabojcza) {
        BarieraZabojcza = barieraZabojcza;
    }


}
