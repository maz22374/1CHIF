/**
 * @author Mazurek David
 * @version 2020-12-16
 */
public class Schleife2 {

    public float folge1(int anzahl) {
        float nenner = 1, zaehler = 1, f = 0;
        int n = 1;
        while (n != anzahl + 1) {
            f += (zaehler / nenner);
            nenner *= 2;
            n++;
        }
        return f;
    }

    public void folge2(int anzahl) {
        int n = 1, z1 = 5, z2 = 5, zaehler = 2;
        while (n <= anzahl) {
            int summe = z1 + z2;
            z1 = z2;
            z2 = summe;
            if (n % 2 == 1) System.out.print("-");
            else System.out.print("+");
            System.out.print(zaehler + "/" + z2 + " ");
            zaehler *= 2;
            n++;
        }
    }

    public boolean istPrimzahl(int n) {
        if (n <= 16) return (n == 2 || n == 3 || n == 5 || n == 7 || n == 11 || n == 13);
        if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0 || n % 7 == 0) return false;

        for (int i = 10; i * i <= n; i += 10) {
            if (n % (i + 1) == 0) return false;
            if (n % (i + 3) == 0) return false;
            if (n % (i + 7) == 0) return false;
            if (n % (i + 9) == 0) return false;
        }
        return true;
    }

    public void berechnePrimzahlen(int start, int ende) {
        if (start > ende) {
            int i = start;
            start = ende;
            ende = i;
        }
        int n = 0;
        for (int i = 0; i <= ende; i++) {
            if (istPrimzahl(i)) {
                System.out.print(i + " ");
                n++;
            } else continue;
            if (n % 10 == 0) System.out.println();
        }
    }

    public int aegyptischeMultiplikation(int zahl1, int zahl2) {
        int produkt = 0;
        while (zahl1 > 0) {
            if (zahl1 % 2 == 1)
                produkt += zahl2;
            zahl2 *= 2;
            zahl1 = zahl1 >> 1;
        }
        return produkt;
    }

    public void testeAegyptischeMultiplikation(int zahl1, int zahl2) {
        if (aegyptischeMultiplikation(zahl1, zahl2) == (zahl1 * zahl2))
            System.out.println("Die Methode 'aegyptischeMultiplikation()' stimmt mit dem Ergebniss " +
                    zahl1 + " * " + zahl2 + " = " + (zahl1 * zahl2) + " überein");
        else
            System.out.println("Die Methode 'aegyptischeMultiplikation()' stimmt mit dem Ergebniss " +
                    zahl1 + " * " + zahl2 + " = " + (zahl1 * zahl2) + " NICHT überein");
    }
}
