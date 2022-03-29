package ActionPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import java.io.Serializable;
import java.util.ArrayList;

public class EmitujFeromon implements InterfejsAkcja, Serializable {
    @Override
    public void robienie(Istota is, double wynik) {
        int x = is.getWspolrzednaAktualnaX();
        int y = is.getWspolrzednaAktualnaY();


        if(x-is.getZasiegWyczuwania()>0 && x+ is.getZasiegWyczuwania()<127 && y-is.getZasiegWyczuwania()>0 && y+ is.getZasiegWyczuwania()<127){
            for(int i = x-is.getZasiegWyczuwania(); i<= x+ is.getZasiegWyczuwania(); i++){
                for(int j = y-is.getZasiegWyczuwania(); j<= y+ is.getZasiegWyczuwania(); j++){
                    if(is.getStanAktualny().getMacierzAktualna()[i][j].getWartosciFeromonu()<wynik)
                        is.getStanAktualny().getMacierzAktualna()[i][j].setWartosciFeromonu(wynik);
                }
            }
        }

    }
}
