/**
 * @author David Mazurek
 * @version 2021-04-28
 */
public class CopyShop {

    Kopierer gereate[];

    public CopyShop() {
        gereate = new Kopierer[4];
    }

    public CopyShop(int maxAnzahl, Kopierer k) {
        if (maxAnzahl > 0)
            gereate = new Kopierer[maxAnzahl];
        else {
            System.err.println("Ung�ltiger Wert --> Wird auf Default gesetzt");
            gereate = new Kopierer[4];
        }
        if (k == null)
            gereate[0] = new Kopierer();
        else
            gereate[0] = k;
    }

    public boolean geraetAufstellen(Kopierer geraet, int stellplatz) {
        boolean erfolgreich = true;
        if (stellplatz >= gereate.length || gereate[stellplatz] != null) {
            System.err.println("Ungültiger Wert");
            return false;
        } else {
            boolean vorhanden;
            for (int i = 0; i < gereate.length; i++) {
                if (gereate[i] == geraet) {
                    vorhanden = true;
                    System.err.println("Objekt schon vorhanden");
                    break;
                } else {
                    gereate[stellplatz] = geraet;
                    return true;
                }
            }
        }
        return erfolgreich;
    }

    public Kopierer geraetEntfernen(int stellplatz) {
        Kopierer entfernt = null;
        if (stellplatz > 0 && stellplatz < gereate.length) {
            entfernt = gereate[stellplatz - 1];
            gereate[stellplatz] = null;
        } else {
            System.out.println("ungültige Nummer angegeben: " + stellplatz);
        }
        return entfernt;
    }

    public int berechneMoeglicheKopien() {
        int kopien = 0;
        for (int i = 0; i < gereate.length; i++) {
            if (gereate[i] != null) {
                if (gereate[i].getDefekt() == false) {
                    kopien += gereate[i].getPapier();
                }
            }
        }
        return kopien;
    }

    public void printInfo() {
        for (int i = 0; i < gereate.length; i++) {
            System.out.println("Kopierer " + (i + 1) + ":");
            if (gereate[i] != null) {
                gereate[i].printInfo();
            } else {
                System.out.println("nicht vorhanden");
            }
        }
    }
}