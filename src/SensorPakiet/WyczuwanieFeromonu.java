package SensorPakiet;

import IstotaPakiet.Istota;
import RozmieszczeniePakiet.Operator;
import RozmieszczeniePakiet.Punkt;

import javax.crypto.Mac;
import java.io.Serializable;
import java.util.ArrayList;

public class WyczuwanieFeromonu implements InterfejsSensoru, Serializable {
    @Override
    public void sensorowanie( Istota is, SensorNeuron sensorAktualny) {
        double max =0;
        int xDlaMaxa = 0;
        int yDlaMaxa = 0;
        int x = is.getWspolrzednaAktualnaX();
        int y = is.getWspolrzednaAktualnaY();

        sensorAktualny.SprawdzPozaZakres(x,y,is, 2);

        for(int i = x-is.getZasiegWyczuwania(); i<= x+ is.getZasiegWyczuwania(); i++){
            for(int j = y-is.getZasiegWyczuwania(); j<= y+ is.getZasiegWyczuwania(); j++) {
                if(max< is.getStanAktualny().getMacierzAktualna()[i][j].getWartosciFeromonu()){
                    max = is.getStanAktualny().getMacierzAktualna()[i][j].getWartosciFeromonu();
                    xDlaMaxa = i;
                    yDlaMaxa = j;
                }
            }
            }
        if(max != 0){
            is.KierunekNaPole(xDlaMaxa, yDlaMaxa);
            sensorAktualny.poinforum();
        }

        }
    }

