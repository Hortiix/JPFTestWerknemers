package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import java.math.BigDecimal;

public class Arbeider extends Werknemer {
    private BigDecimal uurloon;
    private static final BigDecimal MIN_UURLOON = BigDecimal.valueOf(9.76d);

    public Arbeider(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setUurloon(uurloon);

    }

    @Override
    public String toString() {
        return super.toString() + "\t" + uurloon;
    }

    public BigDecimal getUurloon() {
        return uurloon;
    }

    public void setUurloon(BigDecimal uurloon) {
        if (uurloon.compareTo(MIN_UURLOON) < 0)
            throw new WerknemersException("Uurloon moet minimum :" + MIN_UURLOON);
        this.uurloon = uurloon;
    }
}
