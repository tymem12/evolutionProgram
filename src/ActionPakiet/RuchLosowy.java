package ActionPakiet;

import IstotaPakiet.Istota;
import Narzedzia.Losowe;
import IstotaPakiet.Kierunek;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class RuchLosowy implements InterfejsAkcja, Serializable {

    @Override
    public void robienie(Istota is,  double wynik) {
       int parametr = Losowe.LosowaWZakresie(0,8);
       switch(parametr){
           case 0:{
               is.setKierunek(Kierunek.N);
               break;
           }
           case 1:{
               is.setKierunek(Kierunek.NW);
               break;
           }
           case 2:{
               is.setKierunek(Kierunek.W);
               break;
           }
           case 3:{
               is.setKierunek(Kierunek.WS);
               break;
           }
           case 4:{
               is.setKierunek(Kierunek.S);
               break;
           }
           case 5:{
               is.setKierunek(Kierunek.SE);
               break;
           }
           case 6:{
               is.setKierunek(Kierunek.E);
               break;
           }
           case 7:{
                   is.setKierunek(Kierunek.EN);
               break;
           }
           case 8:{
               is.setKierunek(Kierunek.CENTRE);
               break;
           }
       }

        is.RuchWKierunku(false);
        is.SprawdzCzyPoleZabija();

 //  }



    }
}
