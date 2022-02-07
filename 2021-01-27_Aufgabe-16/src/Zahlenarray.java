import java.util.Random;

/**
 * @author Mazurek David
 * @version 2021-01-27
 */
public class Zahlenarray {

    private int[] zahlen;

    public Zahlenarray() {
        zahlen = new int[10];
    }

    public Zahlenarray(int groesse) {
        zahlen = new int[groesse];
    }

    public void zuweisen(int index, int wert) {
        if (index < zahlen.length)
            zahlen[index] = wert;
    }

    public void zufall(int von, int bis) {
        Random random = new Random();
        for (int i = 0; i < zahlen.length; i++) {
            int n = random.nextInt(bis + von) + von;
            zahlen[i] = n;
        }
    }

    public int minimum() {
        int min = zahlen[0];
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < min)
                min = zahlen[i];
        }
        return min;
    }

    public int minimumIndex() {
        int min = zahlen[0];
        int n = 0;
        for (int i = 0; i < zahlen.length; i++) {
            if (zahlen[i] < min) {
                min = zahlen[i];
                n = i;
            }
        }
        return n;
    }

    public void ausgabe(int vonIndex, int bisIndex) {
        if (bisIndex < zahlen.length) {
            for (int i = vonIndex; i <= bisIndex; i++) {
                System.out.println("zahlen[" + i + "] = " + zahlen[i]);
            }
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

    public void berechnePrimzahlen(int bis) {
        int index = 0;
        for (int i = 0; i <= bis; i++) {
            if (istPrimzahl(i)) {
                zuweisen(index, i);
                index++;
            } else
                continue;
        }
        ausgabe(0, zahlen.length - 1);
    }

    public int summe() {
        int n = 0;
        for (int i = 0; i < zahlen.length; i++) {
            n += zahlen[i];
        }
        return n;
    }

    public float arithmetischesMittel() {
        int n = summe();
        return (float) n / zahlen.length;
    }

    public void ausgabeBalken() {
        for (int i = 0; i < zahlen.length; i++) {
            if (i + 1 < 10)
                System.out.print("0" + (i + 1) + ". Zahl: ");
            else
                System.out.print((i + 1) + ". Zahl: ");
            for (int j = 0; j < zahlen[i]; j++) {
                System.out.print("#");
            }
            System.out.println();
        }
        System.out.println("Summe: " + summe());
        System.out.println("Mittelwert: " + arithmetischesMittel());
    }

    public void eratosthenes(int num) {
        boolean prime[] = new boolean[num + 1];
        for (int i = 2; i <= num; i++) {
            prime[i] = true;
        }
        for (int p = 2; p <= Math.sqrt(num); p++) {
            if (prime[p]) {
                for (int j = p; j * p <= num; j++) {
                    prime[j * p] = false;
                }
            }
        }
        for (int i = 2; i <= num; i++) {
            if (prime[i]) {
                System.out.println(i + " ");
            }
        }
    }
}
