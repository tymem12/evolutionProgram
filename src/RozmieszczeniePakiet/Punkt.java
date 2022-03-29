package RozmieszczeniePakiet;

import java.io.Serial;
import java.io.Serializable;

public class Punkt implements Serializable {

    @Serial
    private static final long serialVersionUID = 2987291479850026451L;
    private boolean zajeta;
    private boolean czyFeromon;
    private boolean czyPreszkoda;
    private double wartosciFeromonu;
    private boolean czyBezpieczny;
    private boolean czyZabija;

    public Punkt() {
       
        zajeta = false;
       czyPreszkoda = false;
        wartosciFeromonu =0;
        czyBezpieczny = false;
        czyZabija = false;

    }

    public boolean isZajeta() {
        return zajeta;
    }

    public void setZajeta(boolean zajeta) {
        this.zajeta = zajeta;
    }

    public boolean isCzyFeromon() {
        return czyFeromon;
    }

    public void setCzyFeromon(boolean czyFeromon) {
        this.czyFeromon = czyFeromon;
    }

    public boolean isCzyPreszkoda() {
        return czyPreszkoda;
    }

    public void setCzyPreszkoda(boolean czyPreszkoda) {
        this.czyPreszkoda = czyPreszkoda;
    }

    public double getWartosciFeromonu() {
        return wartosciFeromonu;
    }

    public void setWartosciFeromonu(double wartosciFeromonu) {
        this.wartosciFeromonu = wartosciFeromonu;
    }

    public boolean getCzyBezpieczny() {
        return czyBezpieczny;
    }

    public void setCzyBezpieczny(boolean czyBezpieczny) {
        this.czyBezpieczny = czyBezpieczny;
    }

    public boolean isCzyBezpieczny() {
        return czyBezpieczny;
    }

    public boolean isCzyZabija() {
        return czyZabija;
    }

    public void setCzyZabija(boolean czyZabija) {
        this.czyZabija = czyZabija;
    }
}
