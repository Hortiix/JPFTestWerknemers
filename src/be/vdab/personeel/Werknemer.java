package be.vdab.personeel;

import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public abstract class Werknemer implements Comparable<Werknemer>, Serializable {
    private static final long serialVersionUID = 1L;
    private final int personeelsnummer;
    private WerknemersDatum datumInDienst;
    private String naam;
    private Geslacht geslacht;

    public Werknemer(int personeelsnummer, WerknemersDatum datumInDienst, String naam, Geslacht geslacht) {
        if (personeelsnummer < 1) throw new WerknemersException("ongeldige personeelsnummer");
        this.personeelsnummer = personeelsnummer;
        setDatumInDienst(datumInDienst);
        setNaam(naam);
        setGeslacht(geslacht);
    }

    public abstract BigDecimal getVerloning();

    public WerknemersDatum getDatumInDienst() {
        return datumInDienst;
    }

    public void setDatumInDienst(WerknemersDatum datumInDienst) {
        // if (datumInDienst == null) throw new WerknemersException("datumInDienst kan niet null zijn");
        this.datumInDienst = datumInDienst;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.isBlank()) throw new WerknemersException("naam kan niet leeg of null zijn");
        this.naam = naam;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        if (geslacht == null) throw new WerknemersException("geslacht kan niet null zijn");
        this.geslacht = geslacht;
    }

    public int getPersoneelsnummer() {
        return personeelsnummer;
    }

    @Override
    public int compareTo(Werknemer o) {
        return this.personeelsnummer - o.getPersoneelsnummer();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Werknemer werknemer = (Werknemer) o;
        return personeelsnummer == werknemer.personeelsnummer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personeelsnummer);
    }

    @Override
    public String toString() {
        return getPersoneelsnummer() + "\t" + getDatumInDienst() + "\t" + getNaam() + "\t" + getGeslacht() +"\t"+getVerloning();
    }

}
