package be.vdab.util;

public enum Geslacht {
    M("man"), V("vrouw");

    private String geslacht;

    Geslacht(String geslacht) {
        this.geslacht = geslacht;
    }

    @Override
    public String toString() {
        return geslacht;
    }

}
