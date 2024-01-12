package be.vdab.personeel.kader;

import be.vdab.personeel.Bediende;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

public class Kaderlid extends Bediende implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    public enum Functietitel {
        DIRECTEUR,
        CEO,
        MANAGER
    }
    private Functietitel functietitel;

    public Kaderlid(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht, BigDecimal maandwedde, Functietitel functietitel) {
        super(personeelsnummer, datumInDienst, naam, geslacht, maandwedde);
        setFunctietitel(functietitel);
    }

    public Functietitel getFunctietitel() {
        return functietitel;
    }

    public void setFunctietitel(Functietitel functietitel) {
        if (functietitel == null) throw new WerknemersException("moet en functietitel doorgeven");
        this.functietitel = functietitel;
    }

    @Override
    public String toString() {
        return super.toString()+"\t"+ functietitel;
    }
}
