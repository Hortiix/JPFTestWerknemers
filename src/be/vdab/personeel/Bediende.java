package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import java.math.BigDecimal;

public class Bediende extends Werknemer {
    private BigDecimal maandwedde;
    private static final BigDecimal MIN_MAANDWEDDE = BigDecimal.valueOf(1129.47);

    public Bediende(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde) {
        super(personeelsnummer, datumInDienst, naam, geslacht);
        setMaandwedde(maandwedde);
    }

    public BigDecimal getMaandwedde() {
        return maandwedde;
    }

    public void setMaandwedde(BigDecimal maandwedde) {
        if (maandwedde.compareTo(MIN_MAANDWEDDE) < 0)
            throw new WerknemersException("Maandwedde moet minimum : " + MIN_MAANDWEDDE);
        this.maandwedde = maandwedde;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + maandwedde;
    }
}
