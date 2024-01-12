package be.vdab.util;

public class WerknemersDatum extends Datum{
    private static final Datum DATUMMINIMAAL = new Datum(12,02,1977);
    public WerknemersDatum(int dag, int maand, int jaar) {
        super(dag, maand, jaar);
        if(this.compareTo(DATUMMINIMAAL)>0) throw new DatumException("Werknemers datum can niet ouder dan "+ DATUMMINIMAAL);
    }
}
