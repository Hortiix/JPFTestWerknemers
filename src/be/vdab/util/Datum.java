package be.vdab.util;

import java.util.Objects;

public class Datum implements IDatum, Comparable<Datum> {
    private final int dag, maand, jaar;
    private final int[] DAG_MAAND = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Datum(int dag, int maand, int jaar) {
        if (!isValidate(dag, maand, jaar)) throw new DatumException();
        this.dag = dag;
        this.maand = maand;
        this.jaar = jaar;
    }

    private boolean isValidate(int dag, int maand, int jaar) {
        if (jaar < 1584 || jaar > 4099) return false;
        if (maand > 12 || maand < 1) return false;
        if (dag < 1) return false;
        if (maand == 2 && isSchrikkeljaar(jaar)) return dag <= DAG_MAAND[2] + 1;
        return dag <= DAG_MAAND[maand];

    }

    private boolean isSchrikkeljaar(int jaar) {
        return (jaar % 4 == 0) && (jaar % 100 != 0 || jaar % 400 == 0);
    }

    @Override
    public int getDag() {
        return dag;
    }

    @Override
    public int getMaand() {
        return maand;
    }

    @Override
    public int getJaar() {
        return jaar;
    }

    @Override
    public String toString() {
        return dag + "/" + maand + "/" + jaar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Datum datum = (Datum) o;
        return dag == datum.dag && maand == datum.maand && jaar == datum.jaar;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dag, maand, jaar);
    }

    @Override
    public int compareTo(Datum o) {
        if (this.jaar - o.getJaar() != 0) return this.jaar - o.getJaar();
        if (this.maand - o.getMaand() != 0) return this.maand - o.getMaand();
        return this.dag - o.getDag();
    }


}
