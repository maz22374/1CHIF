package Teil1;

/**
 * @author Mazurek David
 * @version 2020-09-23
 */
public class Flugzeug {

    private String fluglinie, hersteller;
    private int passagiere, eigengewicht;
    private boolean imFlug;

    public Flugzeug() {
        setFluglinie("Austrian Airlines");
        setHersteller("Aero Commander");
        setPassagiere(50);
        setEigengewicht(80000);
        setImFlug(true);
    }

    public Flugzeug(String fluglinie, String hersteller, int passagiere, int eigengewicht, boolean imFlug) {
        setFluglinie(fluglinie);
        setHersteller(hersteller);
        setPassagiere(passagiere);
        setEigengewicht(eigengewicht);
        setImFlug(imFlug);
    }

    public String getFluglinie() {
        return fluglinie;
    }

    public void setFluglinie(String fluglinie) {
        this.fluglinie = fluglinie;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public int getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(int passagiere) {
        this.passagiere = passagiere;
    }

    public int getEigengewicht() {
        return eigengewicht;
    }

    public void setEigengewicht(int eigengewicht) {
        this.eigengewicht = eigengewicht;
    }

    public boolean getImFlug() {
        return imFlug;
    }

    public void setImFlug(boolean imFlug) {
        this.imFlug = imFlug;
    }

    public int berechneGewicht() {
        return getEigengewicht() + 80 * getPassagiere();
    }

    public void printInfo() {
        System.out.println("Fluglinie = " + getFluglinie());
        System.out.println("Hersteller = " + getHersteller());
        System.out.println("Passagiere = " + getPassagiere());
        System.out.println("Eigengewicht = " + getEigengewicht());
        System.out.println("Gerade im Flug: " + (getImFlug() ? "Ja" : "Nein"));
    }
}