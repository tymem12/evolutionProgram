package ActionPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import Narzedzia.Losowe;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class Zabij implements InterfejsAkcja, Serializable {
    double sznsaNaUjawnienie = 0;

    @Override
    public void robienie(Istota is,  double wynik ) {
        if(sznsaNaUjawnienie ==0){
            sznsaNaUjawnienie = Losowe.GenerujDoubla();
        }


            int[] wspolrzedne = is.OkreslPolozenieWzgeledmKierunku();
            int x = wspolrzedne[0];
            int y = wspolrzedne[1];
            if(is.getKierunek() != Kierunek.CENTRE){
                if(!(is.getStanAktualny().getMacierzAktualna()[x][y].isCzyPreszkoda())) {
                     if (is.getStanAktualny().getMacierzAktualna()[x][y].isZajeta()) {
                         if(sznsaNaUjawnienie<=0.005){
                        // if(Losowe.GenerujDoubla()<0.005){
                        for (int i = 0; i < is.getStanAktualny().getWszystkieIstoty().size(); i++) {
                            if (is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaX() == x &&
                                    is.getStanAktualny().getWszystkieIstoty().get(i).getWspolrzednaAktualnaY() == y) {
                                is.getStanAktualny().getWszystkieIstoty().get(i).setCzyZywa(false);
                                is.getStanAktualny().setLiczbaZabitych(is.getStanAktualny().getLiczbaZabitych() + 1);
                                is.getStanAktualny().getWszystkieIstoty().remove(is.getStanAktualny().getWszystkieIstoty().get(i));
                                i = is.getStanAktualny().getWszystkieIstoty().size() + 1;
                            }
                            }
                         }
                     }

                is.RuchWKierunku(false);
                   is.SprawdzCzyPoleZabija();
                }
            }

        }
}
