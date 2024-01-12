package be.vdab;

import be.vdab.util.Datum;
import be.vdab.util.DatumException;

import java.util.ArrayList;

public class DatumTest {


    public static void main(String[] args) {
        testConstructor();
        testEquals();
        testComparTo();
    }

    private static void testComparTo() {
        System.out.println();
        System.out.println("TEST : equals");
        System.out.println("verwacht resultaat : datum sorter");
        ArrayList<Datum> datumLijst = new ArrayList<>();
        datumLijst.add(new Datum(6, 1, 1990));
        datumLijst.add(new Datum(7, 1, 1990));
        datumLijst.add(new Datum(6, 2, 1990));
        datumLijst.add(new Datum(1, 1, 1991));
        datumLijst.add(new Datum(6, 1, 1989));
        datumLijst.add(new Datum(28, 9, 2008));

        datumLijst.stream().sorted().forEach(System.out::println);


    }

    private static void testEquals() {
        System.out.println();
        System.out.println("TEST : equals");
        System.out.println("verwacht resultaat : true , true , false , false");
        Datum datum1 = new Datum(1, 1, 1584);
        Datum datum2 = new Datum(1, 1, 1584);
        Datum datum3 = datum1;
        Datum datum4 = new Datum(1, 3, 1584);
        String datum5 = "1/1/1584";
        System.out.println(datum1.equals(datum2));
        System.out.println(datum1.equals(datum3));
        System.out.println(datum1.equals(datum4));
        System.out.println(datum1.equals(datum5));
    }

    private static void testConstructor() {
        System.out.println("TEST : Constructor");
        System.out.println("verwacht resultaat : 25/4/1908");
        Datum datum = null;
        try {
            datum = new Datum(25, 4, 1908);
        } finally {
            System.out.println("resultaat: " + datum);
        }
        System.out.println();
        System.out.println("TEST Schrikkeljaar constructor _____");
        System.out.println("verwacht resultaat : 29/2/2024");
        //System.out.println((2024 % 4 == 0) && (2024 % 100 != 0 || 2024 % 400 == 0));
        try {
            datum = new Datum(29, 2, 2024);
        } finally {
            System.out.println("resultaat: " + datum);
        }
        System.out.println("verwacht resultaat : DatumException");
        String resultaat = null;
        try {
            datum = new Datum(29, 2, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST dag = 31 in a 30 dag maand ");
        System.out.println("verwacht resultaat : DatumException");

        try {
            datum = new Datum(31, 6, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST dag < 1");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(0, 6, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST dag > 31");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(98, 6, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }

        System.out.println();
        System.out.println("TEST maand < 0 ");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(12, 0, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST maand > 12 ");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(12, 13, 2023);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST jaar < 1584 ");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(12, 5, 1583);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println();
        System.out.println("TEST jaar > 4099 ");
        System.out.println("verwacht resultaat : DatumException");


        try {
            datum = new Datum(12, 5, 4100);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        System.out.println("_____TEST LIMITE____");
        try {
            datum = new Datum(1, 1, 1584);
            resultaat = datum.toString();
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat moet: 1/1/1584");
            System.out.println("resultaat: " + resultaat);
        }
        resultaat = null;
        try {
            datum = new Datum(31, 12, 1583);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }
        resultaat = null;
        try {
            resultaat = new Datum(31, 12, 4099).toString();
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat moet: 31/12/4099");
            System.out.println("resultaat: " + resultaat);
        }
        resultaat = null;
        try {
            datum = new Datum(1, 1, 4100);
        } catch (DatumException ex) {
            resultaat = ex.getMessage();
        } finally {
            System.out.println("resultaat: " + resultaat);
        }


    }
}
