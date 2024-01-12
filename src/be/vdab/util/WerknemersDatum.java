package be.vdab.util;

import java.io.Serial;
import java.io.Serializable;

public class WerknemersDatum extends Datum implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private static final Datum DATUMMINIMAAL = new Datum(12, 02, 1977);

    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
        if (this.compareTo(DATUMMINIMAAL) < 0)
            throw new DatumException("Werknemers datum can niet ouder dan " + DATUMMINIMAAL);
    }
}
