import java.util.Random;

/**
 * @author Mazurek David
 * @version 2021-01-20
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
}
