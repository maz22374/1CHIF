/**
 * @author Mazurek David
 * @version 2020-12-16
 */
public class Schleife {

    private int limit;

    public Schleife() {
        setLimit(10);
    }

    public Schleife(int limit) {
        setLimit(limit);
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= -20 && limit <= 20)
            this.limit = limit;
        else {
            System.err.println("Ungültiger Wert 'limit' --> Default");
            setLimit(10);
        }
    }

    public void schleife1() {
        int n = 0;
        do {
            System.out.println(n);
            n++;
        }
        while (n != limit + 1);
    }

    public void schleife2(int start) {
        int n = start;
        if (n > limit + 1) {
            while (n != limit + 1) {
                System.out.println(n);
                n--;
            }
        } else if (n < limit + 1) {
            while (n != limit + 1) {
                System.out.println(n);
                n++;
            }
        }
    }

    public void schleife3(int p1, int p2) {
        if (p1 > p2) {
            while (p2 != p1 + 1) {
                System.out.println(p2);
                p2++;
            }
        } else if (p2 > p1) {
            while (p1 != p2 + 1) {
                System.out.println(p1);
                p1++;
            }
        }
    }

    public void schleife4(int start) {
        int n = start;
        if (n > limit + 1) {
            while (n != limit + 1) {
                if (n % 2 == 0)
                    System.out.println(n);
                n--;
            }
        } else if (n < limit + 1) {
            while (n != limit + 1) {
                if (n % 2 == 0)
                    System.out.println(n);
                n++;
            }
        }
    }

    public void schleife5(String zeichen, int anzahl) {
        int n = 0;
        while (anzahl != n) {
            System.out.print(zeichen);
            n++;
        }
    }

    public double a_hoch_n(int a, int n) {
        return Math.pow(a, n);
    }

    public void folge(int anzahl) {
        int zaehler = 1;
        int nenner = 1;
        int n = 1;
        while (n != anzahl + 1) {
            if (n % 3 == 0)
                System.out.print("-");
            System.out.print(zaehler + "/" + nenner);
            if (n != anzahl)
                System.out.print(", ");
            zaehler *= 3;
            nenner += n;
            n++;
        }
    }

    public int berechneQuersumme(int zahl) {
        int summe = 0;
        while (0 != zahl) {
            summe = summe + (zahl % 10);
            zahl = zahl / 10;
        }
        return summe;
    }
}
