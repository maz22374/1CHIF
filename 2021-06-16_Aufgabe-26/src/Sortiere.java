import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author David Mazurek
 * @version 2021-06-16
 */
public class Sortiere {

    int[] werte;

    public Sortiere() {
        werte = new int[500];
    }

    public Sortiere(int n) {
        werte = new int[n];
    }

    public void initialisiere() {
        for (int i = 0; i < werte.length; i++) {
            werte[i] = ThreadLocalRandom.current().nextInt(1, 100);
        }
    }

    public int bubblesort() {
        for (int i = 1; i < werte.length; i++) {
            for (int j = 0; j < werte.length - i; j++) {
                if (werte[j] > werte[j + 1]) {
                    int temp = werte[j];
                    werte[j] = werte[j + 1];
                    werte[j + 1] = temp;
                }
            }
        }
        return 0;
    }

    public int insertionsort() {
        for (int i = 1; i < werte.length; i++) {
            int temp = werte[i];
            int j = i;
            while (j > 0 && werte[j - 1] > temp) {
                werte[j] = werte[j - 1];
                j--;
            }
            werte[j] = temp;
        }
        return 0;
    }

    public int selectionsort() {
        int i, j, min, temp;
        for (i = 0; i < werte.length; i++) {
            min = i;
            for (j = i + 1; j < werte.length; j++) {
                if (werte[j] < werte[min])
                    min = j;
            }
            temp = werte[min];
            werte[min] = werte[i];
            werte[i] = temp;
        }
        return 0;
    }

    public int bogoSort() {
        Random r = new Random();
        while (!isSorted(werte)) {
            int a = r.nextInt(werte.length);
            int b = r.nextInt(werte.length);

            int temp = werte[a];
            werte[a] = werte[b];
            werte[b] = temp;
        }
        return 0;
    }

    public int ripplesort() {
        boolean switched;
        do {
            switched = false;
            for (int i = 0; i < werte.length - 1; i++) {
                if (werte[i] > werte[i + 1]) {
                    int k = werte[i];
                    werte[i] = werte[i + 1];
                    werte[i + 1] = k;
                    switched = true;
                }
            }
        } while (switched == true);
        return 0;
    }

    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public void ausgabe() {
        for (int i = 0; i < werte.length; i++) {
            System.out.print(werte[i] + "  ");
        }
        System.out.println();
    }
}
