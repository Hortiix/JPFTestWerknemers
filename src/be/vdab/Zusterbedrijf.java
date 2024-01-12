package be.vdab;

import be.vdab.personeel.Bedrijf;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Zusterbedrijf {
    private final Bedrijf bedrijf;

    public Zusterbedrijf() {
        this.bedrijf = leesBedrifFile(Bedrijf.PATH);
    }

    public Bedrijf getBedrijf() {
        return bedrijf;
    }

    public static Bedrijf leesBedrifFile (Path path){
        try (var stream = new ObjectInputStream(Files.newInputStream(path))){
            return  (Bedrijf) stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
