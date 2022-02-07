/**
 * @author Mazurek David
 * @version 2020-11-24
 */
public class Taxi {

    private boolean frei;
    private int fahrgaeste, maxPlatz;

    public Taxi() {
        setFrei(true);
        setMaxPlatz(3);
        setFahrgaeste(0);
    }

    public Taxi(int maxPlatz) {
        setFrei(true);
        setMaxPlatz(maxPlatz);
        setFahrgaeste(0);
    }

    public boolean isFrei() {
        return frei;
    }

    public void setFrei(boolean frei) {
        this.frei = frei;
        if (frei)
            this.fahrgaeste = 0;
    }

    public void setFahrgaeste(int fahrgaeste) {
        if (fahrgaeste < 0 || fahrgaeste > maxPlatz)
            System.out.println("ungültiger Wert für fahrgaeste");
        else
            this.fahrgaeste = fahrgaeste;
        frei = fahrgaeste == 0;
    }

    public int getFahrgaeste() {
        return fahrgaeste;
    }

    public int getMaxPlatz() {
        return this.maxPlatz;
    }

    private void setMaxPlatz(int maxPlatz) {
        if (maxPlatz >= 1 && maxPlatz <= 10)
            this.maxPlatz = maxPlatz;
        else {
            System.out.println("Wert für Sitzplätze ungültig -> Default-Wert");
            this.maxPlatz = 4;
        }
    }

    public void einsteigen(int anz) {
        if (anz > 0) {
            int nochPlatz = maxPlatz - fahrgaeste;
            if (anz <= nochPlatz)
                fahrgaeste += anz;
            else {
                System.out.println("nicht Platz für: " + (anz - nochPlatz) + " Person(en)");
                fahrgaeste = maxPlatz;
            }
            frei = fahrgaeste == 0;
        } else
            System.out.println("ungültiger Wert für Anzahl");
    }

    public void aussteigen(int anz) {
        if (anz <= 0)
            System.out.println("ungültiger Wert für Anzahl");
        else {
            if (anz > fahrgaeste - 1)
                fahrgaeste = 0;
            else
                fahrgaeste -= anz;
            frei = fahrgaeste == 0;
        }
    }

    public void printInfo() {
        System.out.println("Taxi frei: " + ((frei) ? "ja" : "nein"));
        System.out.println("Anzahl der Fahrgäste: " + fahrgaeste);
        System.out.println("maximale Anzahl der Fahrgäste: " + maxPlatz);
    }
}
