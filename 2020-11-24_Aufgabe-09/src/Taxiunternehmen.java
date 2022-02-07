/**
 * @author Mazurek David
 * @version 2020-11-24
 */
public class Taxiunternehmen {

    private Taxi t1, t2, t3;

    public Taxiunternehmen() {
        t1 = new Taxi();
        t2 = new Taxi(9);
    }

    public Taxiunternehmen(Taxi taxi) {
        if (taxi == null)
            t1 = new Taxi();
        else
            t1 = taxi;
    }

    public void printInfo() {
        System.out.println("Taxi 1: ");
        t1.printInfo();
        System.out.println("Taxi 2: ");
        if (t2 != null)
            t2.printInfo();
        else
            System.out.println("Es gibt kein zweites Taxi!");
        if (t3 != null)
            t3.printInfo();
        else
            System.out.println("Es gibt kein drittes Taxi!");
    }

    public int anzahlTaxis() {
        int n = 0;
        if (t1 != null)
            n++;
        else if (t2 != null)
            n++;
        else if (t3 != null)
            n++;
        return n;
    }

    public int freiePlaetze() {
        int n = 0;
        if (t1.isFrei())
            n += t1.getMaxPlatz();
        if (t2.isFrei())
            n += t2.getMaxPlatz();
        if (t3.isFrei())
            n += t3.getMaxPlatz();
        return n;
    }

    public void hinzufuegen(Taxi t) {
        if (t != null) {
            if (t != t1 || t != t2) {
                if (t1 == null)
                    t1 = t;
                else if (t2 == null)
                    t2 = t;
                else if (t3 == null)
                    t3 = t;
                else
                    System.err.println("Alle Taxis besetzt");
            }
        }
    }
}
