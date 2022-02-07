package Teil2;

/**
 * @author Mazurek David
 * @version 2020-10-07
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
        if (fluglinie != null)
            this.fluglinie = fluglinie;
        else {
            System.err.println("Ungültiger Wert 'fluglinie' --> Default");
            this.fluglinie = "Unbekannt";
        }
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        if (hersteller != null)
            this.hersteller = hersteller;
        else {
            System.err.println("Ungültiger Wert 'hersteller' --> Default");
            this.hersteller = "Unbekannt";
        }
    }

    public int getPassagiere() {
        return passagiere;
    }

    public void setPassagiere(int passagiere) {
        if (passagiere > 0 && passagiere < 101)
            this.passagiere = passagiere;
        else {
            System.err.println("Ungültiger Wert 'passagiere' --> Default");
            this.passagiere = 10;
        }
    }

    public int getEigengewicht() {
        return eigengewicht;
    }

    public void setEigengewicht(int eigengewicht) {

        if (eigengewicht > 0 && eigengewicht <= 100000)
            this.eigengewicht = eigengewicht;
        else {
            System.err.println("Ungültiger Wert 'eigengewicht' --> Default");
            this.eigengewicht = 50000;
        }
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