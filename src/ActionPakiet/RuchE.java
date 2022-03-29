package ActionPakiet;

import IstotaPakiet.Istota;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class RuchE implements InterfejsAkcja , Serializable {

    public void robienie(Istota is, double wynik) {

        is.setKierunek(Kierunek.E);
        is.RuchWKierunku(false);
        is.SprawdzCzyPoleZabija();

    }

            /*
        } else {
            if ((!(o.getMacierzAktualna()[x - 1][y].isZajeta())) && !o.getMacierzAktualna()[x-1][y].isCzyPreszkoda() ) {
                is.setKierunek(Kierunek.W);
                is.setWspolrzednaAktualnaX(x - 1);
                o.getMacierzAktualna()[x][y].setZajeta(false);
                o.getMacierzAktualna()[x - 1][y].setZajeta(true);
              //  o.PowiadomObserwatorow();
                if(o.getMacierzAktualna()[is.getWspolrzednaAktualnaX()][is.getWspolrzednaAktualnaY()].isCzyZabija()){
                    o.getMacierzAktualna()[is.getWspolrzednaAktualnaX()][is.getWspolrzednaAktualnaY()].setZajeta(false);
                    is.setCzyZywa(false);
                    o.getWszystkieIstoty().remove(is);

                }
            }


        }

             */
    }

