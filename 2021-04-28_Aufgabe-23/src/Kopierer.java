/**
 * @author David Mazurek
 * @version 2021-04-28
 */
public class Kopierer {

    private int papierMaximum, papier;
    private boolean defekt;

    public Kopierer() {
        setPapierMaximum(800);
        setPapier(400);
        setDefekt(false);
    }

    public Kopierer(int papierMaximum, int papier, boolean defekt) {
        setPapierMaximum(papierMaximum);
        setPapier(papier);
        setDefekt(defekt);
    }

    public int getPapierMaximum() {
        return papierMaximum;
    }

    public int getPapier() {
        return papier;
    }

    public boolean getDefekt() {
        return defekt;
    }

    public void setPapierMaximum(int papierMaximum) {
        if (papierMaximum < 2000 && papierMaximum >= 500)
            this.papierMaximum = papierMaximum;
        else {
            System.err.println("Ungültiger Wert --> wird auf Deafault gesetzt");
            this.papierMaximum = 500;
        }
    }

    public void setPapier(int papier) {
        if (papier <= papierMaximum && papier >= 0)
            this.papier = papier;
        else {
            System.err.println("Ungültiger Wert --> wird auf Deafault gesetzt");
            this.papierMaximum = 500;
        }
    }

    public void setDefekt(boolean defekt) {
        this.defekt = defekt;
    }

    public void kopieren(int anzahl) {
        if (defekt || anzahl <= 0 || anzahl > papier || defekt)
            System.err.println("Ungültiger Wert");
        else
            papier = papier - anzahl;
    }

    public int papierNachfuellen(int blatt) {
        if (papier + blatt > papierMaximum || blatt <= 0) {
            System.err.println("Ungültiger Wert");
            return 0;
        } else {
            papier = papier + blatt;
            return papier;
        }
    }

    public void printInfo() {
        System.out.println("maximaler Papiervorrat: " + papierMaximum);
        System.out.println(
                "aktueller Papiervorrat: " + papier + " " + "(" + ((float) papier / papierMaximum) * 100 + "%" + ")");
        System.out.println(getDefekt() ? "einsatzbereit: " + "nein" : "einsatzbereit: " + "ja");
    }
}