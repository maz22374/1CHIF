package Teil1;

/**
 * @author Mazurek David
 * @version 2020-10-07
 */
public class Rechteck {

    private int laenge, breite;

    public Rechteck() {
        setLaenge(25);
        setBreite(25);
    }

    public Rechteck(int laenge, int breite) {
        setLaenge(laenge);
        setBreite(breite);
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

    public int berechneUmfang() {
        return 2 * (this.laenge + this.breite);
    }

    public int berechneFlaeche() {
        return this.laenge * this.breite;
    }

    public void printInfo() {
        System.out.println("Länge = " + getLaenge());
        System.out.println("Breite = " + getBreite());
        System.out.println("Umfang = " + berechneUmfang());
        System.out.println("Fläche = " + berechneFlaeche());
    }
}
