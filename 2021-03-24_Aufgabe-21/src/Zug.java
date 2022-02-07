/**
 * @author Mazurek David
 * @version 2021-03-24
 */
public class Zug {

    private Personenwagon[] wagons;

    public Zug(Personenwagon w) {
        wagons = new Personenwagon[10];
        if (w == null) {
            wagons[0] = new Personenwagon(150, 2);
        } else {
            wagons[0] = w;
        }
    }

    public boolean wagonHinzufuegen(Personenwagon wagon) {
        boolean erfolgreich = false;
        if (wagon == null) {
            System.out.println("kein Wagon-Objekt übergeben");
        } else {
            boolean vorhanden = false;
            for (int i = 0; i < wagons.length; i++) {
                if (wagons[i] == wagon) {
                    vorhanden = true;
                    break;
                }
            }
            if (vorhanden) {
                System.out.println("dieser Wagon ist schon vorhanden");
            } else {
                for (int i = 0; i < wagons.length && !erfolgreich; i++) {
                    if (wagons[i] == null) {
                        wagons[i] = wagon;
                        erfolgreich = true;
                    }
                }
                if (!erfolgreich) {
                    System.out.println("Kein Platz für ein weiteren Wagon!");
                }
            }
        }
        return erfolgreich;
    }

    public int getAnzahlFreieSitzplaetze(int klasse) {
        int frei = 0;
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] != null && (wagons[i].getKlasse() == klasse || klasse == 0)) {
                frei += wagons[i].freiePlaetze();
            }
        }
        return frei;
    }

    public int verteilen(int anzahl, int klasse) {
        for (int i = 0; i < wagons.length; i++) {
            if (wagons[i] != null && (wagons[i].getKlasse() == klasse || klasse == 0)) {
                anzahl = wagons[i].einsteigen(anzahl);
            }
        }
        return anzahl;
    }

    public Personenwagon entfernen(int pos) {
        Personenwagon entfernt = null;
        if (pos > 0 && pos <= wagons.length) {
            entfernt = wagons[pos - 1];
            wagons[pos - 1] = null;
        } else {
            System.out.println("ungültige Nummer angegeben: " + pos);
        }
        return entfernt;
    }

    public void printInfo() {
        for (int i = 0; i < wagons.length; i++) {
            System.out.println("Wagon " + (i + 1) + ":");
            if (wagons[i] != null) {
                wagons[i].printInfo();
            } else {
                System.out.println("nicht vorhanden");
            }
        }
    }
}
