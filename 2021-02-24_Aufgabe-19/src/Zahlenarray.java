import java.util.*;

/**
 * @author Mazurek David
 * @version 2021-02-24
 */
public class Zahlenarray {

    private int[] werte;

    public Zahlenarray(int groesse, int von, int bis) {
        werte = new int[groesse];
        generiereZufallszahlen(von, bis);
    }

    private void generiereZufallszahlen(int von, int bis) {
        Random rnd = new Random();
        for (int i = 0; i < werte.length; i++) {
            werte[i] = von + rnd.nextInt((int) (bis - von) + 1);
            System.out.println("werte[" + i + "] = " + werte[i]);
        }
    }

    public void shuffle(int anzahl) {
        Random rnd = new Random();
        for (int i = 0; i < anzahl; i++) {
            int j = rnd.nextInt(werte.length);
            int n = werte[j];
            werte[j] = werte[i];
            werte[i] = n;
        }
    }

    public int bubbleSortAufsteigend() {
        int k = 0, n = werte.length, temp = 0;
        for (int i = 0; i < n; i++) {
            for (int s = 1; s < (n - i); s++) {
                if (werte[s - 1] < werte[s]) {
                    temp = werte[s - 1];
                    werte[s - 1] = werte[s];
                    werte[s] = temp;
                }
            }
        }
        return k;
    }

    public int bubbleSortAbsteigend() {
        int k = 0, n = werte.length, temp = 0;
        for (int i = 0; i < n; i++) {
            for (int s = 1; s < (n - i); s++) {
                if (werte[s - 1] > werte[s]) {
                    temp = werte[s - 1];
                    werte[s - 1] = werte[s];
                    werte[s] = temp;
                }
            }
        }
        return k;
    }

    private void tauschen(int pos1, int pos2) {
        int speicher1 = werte[pos1], speicher2 = werte[pos2];
        werte[pos1] = speicher2;
        werte[pos2] = speicher1;
    }

    public int insertionSort() {
        int n = werte.length;
        for (int j = 1; j < n; j++) {
            int key = werte[j];
            int i = j - 1;
            while ((i > -1) && (werte[i] > key)) {
                werte[i + 1] = werte[i];
                i--;
            }
            werte[i + 1] = key;
        }
        return n;
    }
}