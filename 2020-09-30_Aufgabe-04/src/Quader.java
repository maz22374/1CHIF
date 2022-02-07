/**
 * @author Mazurek David
 * @version 2020-09-30
 */
public class Quader {

    private int laenge, breite, hoehe, dichte;

    public Quader() {
        setLaenge(25);
        setBreite(25);
        setHoehe(25);
        setDichte(25);
    }

    public Quader(int laenge, int breite, int hoehe, int dichte) {
        setLaenge(laenge);
        setBreite(breite);
        setHoehe(hoehe);
        setDichte(dichte);
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getBreite() {
        return breite;
    }

    public void setBreite(int breite) {
        this.breite = breite;
    }

    public int getHoehe() {
        return hoehe;
    }

    public void setHoehe(int hoehe) {
        this.hoehe = hoehe;
    }

    public int getDichte() {
        return dichte;
    }

    public void setDichte(int dichte) {
        this.dichte = dichte;
    }

    public int berechneOberflaeche() {
        return 2 * (getLaenge() * getBreite() + getLaenge() * getHoehe() + getBreite() * getHoehe());
    }

    public int berechneVolumen() {
        return getLaenge() * getBreite() * getHoehe();
    }

    public int berechneMasse() {
        return berechneVolumen() * getDichte();
    }

    public void printInfo() {
        System.out.println("Länge = " + getLaenge());
        System.out.println("Breite = " + getBreite());
        System.out.println("Höhe = " + getHoehe());
        System.out.println("Dichte = " + getDichte());
        System.out.println("Oberfläche = " + berechneOberflaeche());
        System.out.println("Volumen = " + berechneVolumen());
        System.out.println("Masse = " + berechneMasse());
    }
}
