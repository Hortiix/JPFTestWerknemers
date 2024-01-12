package be.vdab.personeel;

import be.vdab.util.Geslacht;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bedrijf implements Serializable {
    private final List<Werknemer> bedrijfLijst;
    private static final long serialVersionUID = 1L;
    public static final Path PATH = Path.of("data/personeel.dat");

    public Bedrijf() {
        this.bedrijfLijst = new ArrayList<>();
    }

    public List<Werknemer> getBedrijfLijst() {
        return Collections.unmodifiableList(bedrijfLijst);
    }

    public void voegWerknemerToe(Werknemer werknemer){
        if (! bedrijfLijst.contains(werknemer)) bedrijfLijst.add(werknemer);
    }
    public void printLijst(){
        bedrijfLijst.forEach(System.out::println);
    }
    public List<Werknemer> gesorteerdeLijst(){
        return bedrijfLijst.stream()
                .sorted()
                .toList();
    }
    public List<Werknemer> lijstVanArbeiders(){
        return bedrijfLijst.stream()
                .filter(werknemer -> werknemer.getClass().equals(Arbeider.class))
                .toList();
    }
    public double percentageMannelijkeWerknemers(){
        double aantalMan = bedrijfLijst.stream()
                .filter(werknemer -> werknemer.getGeslacht() == Geslacht.M)
                .count();
        return (aantalMan /bedrijfLijst.size())*100;
    }
    public void bewaarLijst(){
        try(var stream = new ObjectOutputStream(Files.newOutputStream(PATH))) {
            stream.writeObject(this);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
