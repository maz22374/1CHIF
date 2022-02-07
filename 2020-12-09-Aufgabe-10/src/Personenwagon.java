/**
 * @author Mazurek David
 * @version 2020-12-09
 */
public class Personenwagon {

    private int maximum, belegt, klasse;

    public Personenwagon(int maximum, int klasse) {
        setMaximum(maximum);
        setKlasse(klasse);
    }

    private void setMaximum(int maximum) {
        if (maximum >= 100 && maximum <= 200 && belegt <= maximum)
            this.maximum = maximum;
        else {
            System.out.println("ungültiger Wert für maximum");
            this.maximum = 100;
        }
    }

    private void setBelegt(int belegt) {
        if (belegt >= 0 && belegt <= maximum)
            this.belegt = belegt;
        else {
            System.out.println("ungültiger Wert für belegt");
            this.belegt = 0;
        }
    }

    public void setKlasse(int klasse) {
        if (klasse == 1 || klasse == 2)
            this.klasse = klasse;
        else {
            System.out.println("ungültiger Wert für klasse");
            this.klasse = 2;
        }
    }


    public int getMaximum() {
        return maximum;
    }

    public int getBelegt() {
        return belegt;
    }

    public int getKlasse() {
        return klasse;
    }

    public int einsteigen(int anzahl) {
        if (anzahl > 0) {
            int frei = maximum - belegt;
            if (anzahl <= frei) {
                belegt += anzahl;
                return 0;
            } else {
                belegt = maximum;
                return anzahl - frei;
            }
        } else {
            System.out.println("negative Anzahl nicht erlaubt");
            return 0;
        }
    }

    public int aussteigen(int anzahl) {
        if (anzahl > 0) {
            if (anzahl <= belegt) {
                belegt -= anzahl;
                return anzahl;
            } else {
                int raus = belegt;
                belegt = 0;
                return raus;
            }
        } else {
            System.out.println("negative Anzahl nicht erlaubt");
            return 0;
        }
    }

    public int freiePlaetze() {
        return maximum - belegt;
    }

    public void printInfo() {
        System.out.println("maximale Anzahl Plätze: " + maximum);
        System.out.println("Anzahl Personen: " + belegt);
        System.out.println("Klasse: " + klasse);
    }
}
