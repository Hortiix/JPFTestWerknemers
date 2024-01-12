package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Arbeider extends Werknemer implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal uurloon;
    private static final BigDecimal MIN_UURLOON = BigDecimal.valueOf(9.76d);

    public Arbeider(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal uurloon) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setUurloon(uurloon);

    }

    @Override
    public BigDecimal getVerloning() {
        return uurloon.multiply((BigDecimal.valueOf(7.6).multiply(BigDecimal.valueOf(65))).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_EVEN));
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
