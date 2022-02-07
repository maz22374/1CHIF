/**
 * @author Mazurek David
 * @version 2020-12-09
 */
public class Zug {

    private Personenwagon w1, w2, w3;

    public Zug(Personenwagon w) {
        if (w == null)
            w1 = new Personenwagon(150, 2);
        else
            w1 = w;
    }

    public void wagonHinzufuegen(Personenwagon wagon) {
        if (wagon != null) {
            if (wagon != w1 && wagon != w2 && wagon != w3) {
                if (w1 == null)
                    w1 = wagon;
                else if (w2 == null)
                    w2 = wagon;
                else if (w3 == null)
                    w3 = wagon;
                else
                    System.out.println("kein weiterer Wagon möglich!");

            } else
                System.out.println("Wagon wurde schon hinzugefügt!");

        } else
            System.out.println("nix zu tun!");
    }

    public int getAnzahlFreieSitzplaetze(int klasse) {
        int frei = 0;
        if (w1 != null && (w1.getKlasse() == klasse || klasse == 0))
            frei += w1.freiePlaetze();
        if (w2 != null && (w2.getKlasse() == klasse || klasse == 0))
            frei += w2.freiePlaetze();
        if (w3 != null && (w3.getKlasse() == klasse || klasse == 0))
            frei += w3.freiePlaetze();
        return frei;
    }

    public int verteilen(int anzahl, int klasse) {
        if (w1 != null && (w1.getKlasse() == klasse || klasse == 0))
            anzahl = w1.einsteigen(anzahl);
        if (w2 != null && (w2.getKlasse() == klasse || klasse == 0))
            anzahl = w2.einsteigen(anzahl);
        if (w3 != null && (w3.getKlasse() == klasse || klasse == 0))
            anzahl = w3.einsteigen(anzahl);
        return anzahl;
    }

    public Personenwagon entfernen(int pos) {
        Personenwagon entfernt = null;
        switch (pos) {
            case 1:
                if (w1 != null) {
                    entfernt = w1;
                    w1 = null;
                }
                break;
            case 2:
                if (w2 != null) {
                    entfernt = w2;
                    w2 = null;
                }
                break;
            case 3:
                if (w3 != null) {
                    entfernt = w3;
                    w3 = null;
                }
                break;
            default:
                System.out.println("ungültige Position angegeben");
        }
        return entfernt;
    }

    public void printInfo() {
        System.out.println("Wagon 1:");
        if (w1 != null)
            w1.printInfo();
        else
            System.out.println("nicht vorhanden");

        System.out.println("Wagon 2:");
        if (w2 != null)
            w2.printInfo();
        else
            System.out.println("nicht vorhanden");

        System.out.println("Wagon 3:");
        if (w3 != null)
            w3.printInfo();
        else
            System.out.println("nicht vorhanden");
    }
}
