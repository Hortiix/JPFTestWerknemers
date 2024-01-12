package be.vdab;

import be.vdab.personeel.Arbeider;
import be.vdab.personeel.Bediende;
import be.vdab.personeel.Bedrijf;
import be.vdab.personeel.kader.Kaderlid;
import be.vdab.util.DatumException;
import be.vdab.util.Geslacht;
import be.vdab.util.WerknemersDatum;
import be.vdab.util.WerknemersException;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.math.BigDecimal;

public class BedrijfApp {
    public static void main(String[] args) {
        Bedrijf bedrijf = initBedrijf();
        werknemersTest();
        bedrijfTest(bedrijf);
        bedrijf.bewaarLijst();
        System.out.println("lees and print");
        var  zusterbedrijf = new Zusterbedrijf();
        zusterbedrijf.getBedrijf().printLijst();

    }

    private static Bedrijf initBedrijf() {
        var a1 = new Arbeider(11, new WerknemersDatum(5, 1, 1999), "Arbeider 1", Geslacht.M, BigDecimal.valueOf(10));
        var a2 = new Arbeider(12, new WerknemersDatum(6, 2, 1999), "Arbeider 2", Geslacht.V, BigDecimal.valueOf(11));
        var a3 = new Arbeider(13, new WerknemersDatum(7, 3, 1999), "Arbeider 3", Geslacht.M, BigDecimal.valueOf(12));
        var a4 = new Arbeider(14, new WerknemersDatum(5, 4, 1999), "Arbeider 4", Geslacht.V, BigDecimal.valueOf(13));
        var a5 = new Arbeider(15, new WerknemersDatum(5, 4, 1999), "Arbeider 5", Geslacht.M, BigDecimal.valueOf(14));
        var a7 = new Arbeider(989, new WerknemersDatum(5, 4, 1999), "Arbeider 5", Geslacht.V, BigDecimal.valueOf(10.98));

        var b1 = new Bediende(21, new WerknemersDatum(8, 6, 2008), "bediende 1", Geslacht.V, BigDecimal.valueOf(1500));
        var b2 = new Bediende(22, new WerknemersDatum(9, 6, 2008), "bediende 1", Geslacht.M, BigDecimal.valueOf(1500));
        var b3 = new Bediende(23, new WerknemersDatum(10, 6, 2008), "bediende 1", Geslacht.V, BigDecimal.valueOf(1500));
        var b4 = new Bediende(24, new WerknemersDatum(11, 6, 2008), "bediende 1", Geslacht.M, BigDecimal.valueOf(1500));
        var b5 = new Bediende(25, new WerknemersDatum(13, 6, 2008), "bediende 1", Geslacht.V, BigDecimal.valueOf(1500));

        var k1 = new Kaderlid(1, new WerknemersDatum(4, 7, 1979), "k1", Geslacht.M, BigDecimal.valueOf(2000), Kaderlid.Functietitel.CEO);
        var k2 = new Kaderlid(2, new WerknemersDatum(4, 7, 1979), "k2", Geslacht.V, BigDecimal.valueOf(2000), Kaderlid.Functietitel.DIRECTEUR);
        var k3 = new Kaderlid(3, new WerknemersDatum(4, 7, 1979), "k3", Geslacht.M, BigDecimal.valueOf(2000), Kaderlid.Functietitel.DIRECTEUR);
        var k4 = new Kaderlid(4, new WerknemersDatum(4, 7, 1979), "k4", Geslacht.V, BigDecimal.valueOf(2000), Kaderlid.Functietitel.MANAGER);
        var k5 = new Kaderlid(5, new WerknemersDatum(4, 7, 1979), "k5", Geslacht.M, BigDecimal.valueOf(2000), Kaderlid.Functietitel.MANAGER);
        //shoouldn't appear in the list
        var k6 = new Kaderlid(5, new WerknemersDatum(4, 7, 1979), "k5", Geslacht.M, BigDecimal.valueOf(2000), Kaderlid.Functietitel.MANAGER);
        var b6 = new Bediende(25, new WerknemersDatum(13, 6, 2008), "bediende 1", Geslacht.V, BigDecimal.valueOf(1500));
        var a6 = new Arbeider(15, new WerknemersDatum(5, 4, 1999), "Arbeider 5", Geslacht.M, BigDecimal.valueOf(14));
        Bedrijf mijnBedrijf = new Bedrijf();
        mijnBedrijf.voegWerknemerToe(a1);
        mijnBedrijf.voegWerknemerToe(a2);
        mijnBedrijf.voegWerknemerToe(a3);
        mijnBedrijf.voegWerknemerToe(a4);
        mijnBedrijf.voegWerknemerToe(a5);
        mijnBedrijf.voegWerknemerToe(a6);
        mijnBedrijf.voegWerknemerToe(a7);
        mijnBedrijf.voegWerknemerToe(b1);
        mijnBedrijf.voegWerknemerToe(b2);
        mijnBedrijf.voegWerknemerToe(b3);
        mijnBedrijf.voegWerknemerToe(b4);
        mijnBedrijf.voegWerknemerToe(b5);
        mijnBedrijf.voegWerknemerToe(b6);
        mijnBedrijf.voegWerknemerToe(k1);
        mijnBedrijf.voegWerknemerToe(k2);
        mijnBedrijf.voegWerknemerToe(k3);
        mijnBedrijf.voegWerknemerToe(k4);
        mijnBedrijf.voegWerknemerToe(k5);
        mijnBedrijf.voegWerknemerToe(k6);
        return mijnBedrijf;
    }

    private static void bedrijfTest(Bedrijf mijnBedrijf ) {


        System.out.println("______________________________________________");
        System.out.println("lijst van bedrijf moet : 16 element -> total element :" + mijnBedrijf.getBedrijfLijst().size());
        mijnBedrijf.getBedrijfLijst().forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("resul van printLijst ");
        System.out.println("______________________________________________");
        mijnBedrijf.printLijst();
        System.out.println("______________________________________________");
        System.out.println("result van gesorteerdeLijst ");
        System.out.println("______________________________________________");
        mijnBedrijf.gesorteerdeLijst().forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("result van lijstVanArbeiders ");
        System.out.println("______________________________________________");
        mijnBedrijf.lijstVanArbeiders().forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("result verwacht is 50 -> result is : " +mijnBedrijf.percentageMannelijkeWerknemers());

    }


    private static void werknemersTest() {

        var abeider = new Arbeider(1, new WerknemersDatum(5, 4, 1999), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        var bediende = new Bediende(3, new WerknemersDatum(5, 4, 1999), "Max Max", Geslacht.M, BigDecimal.valueOf(1500));
        var kader = new Kaderlid(2, new WerknemersDatum(4, 7, 1979), "Gisel Gisel", Geslacht.V, BigDecimal.valueOf(2000), Kaderlid.Functietitel.MANAGER);
        System.out.println(abeider);
        System.out.println(bediende);
        System.out.println(kader);
        System.out.println("-----TEST new personal Nummer-----");
        String result = null;
        Arbeider a = null;
        try {
            a = new Arbeider(0, new WerknemersDatum(5, 4, 1999), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        } catch (WerknemersException ex) {
            result = ex.getMessage();
        } finally {
            System.out.println("vewacht Exceptie -> werneemer : " + a + " exceptie message : " + result);

        }
        a = null;
        try {
            a = new Arbeider(-84, new WerknemersDatum(5, 4, 1999), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        } catch (WerknemersException ex) {
            result = ex.getMessage();
        } finally {
            System.out.println("vewacht Exceptie -> werneemer : " + a + " exceptie message : " + result);


        }
        System.out.println("-----TEST new Datum-----");
        a = null;
        try {
            a = new Arbeider(1, new WerknemersDatum(11, 2, 1977), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        } catch (DatumException ex) {
            result = ex.getMessage();
        } finally {
            System.out.println("vewacht Exceptie -> werneemer : " + a + " exceptie message : " + result);

        }
        a = null;
        try {
            a = new Arbeider(1, new WerknemersDatum(5, 4, 1089), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        } catch (DatumException ex) {
            result = ex.getMessage();
        } finally {
            System.out.println("vewacht Exceptie -> werneemer : " + a + " exceptie message : " + result);
        }
        a = null;
        try {
            a = new Arbeider(1, new WerknemersDatum(12, 2, 1977), "Max Max", Geslacht.M, BigDecimal.valueOf(10));
        } catch (DatumException ex) {
            result = ex.getMessage();
        } finally {
            System.out.println("vewacht geen exceptie -> werneemer : " + a + " exceptie message : " + result);
        }

        //TODO GESLACHT
        //TODO UURLOON
        //TODO MAANDGEG
    }
}
