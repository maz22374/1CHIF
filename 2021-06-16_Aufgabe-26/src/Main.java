/**
 * @author David Mazurek
 * @version 2021-06-16
 */
public class Main {

    public static void main(String[] args) {
        Sortiere sd = new Sortiere();
        sd.initialisiere();
        System.out.println("Bubble sort");
        System.out.println("Felder: " + sd.werte.length);
        System.out.println("Unsortiertes Feld:");
        sd.ausgabe();
        long start = System.currentTimeMillis();
        int aufwand = sd.bubblesort();
        long ende = System.currentTimeMillis();
        System.out.println("Sortiertes Feld:");
        sd.ausgabe();
        System.out.println("\nBenötigte Zeit: msk: " + (ende - start));
        System.out.println(
                "********************************************************************************************");
        sd = new Sortiere();
        sd.initialisiere();
        System.out.println("Insertion sort");
        System.out.println("Felder: " + sd.werte.length);
        System.out.println("Unsortiertes Feld:");
        sd.ausgabe();
        long start1 = System.currentTimeMillis();
        int aufwand1 = sd.insertionsort();
        long ende1 = System.currentTimeMillis();
        System.out.println("Sortiertes Feld:");
        sd.ausgabe();
        System.out.println("\nBenötigte Zeit: msk: " + (ende1 - start1));
        System.out.println(
                "********************************************************************************************");
        sd = new Sortiere();
        sd.initialisiere();
        System.out.println("Selection Sort");
        System.out.println("Felder: " + sd.werte.length);
        System.out.println("Unsortiertes Feld:");
        sd.ausgabe();
        long start2 = System.currentTimeMillis();
        int aufwand2 = sd.selectionsort();
        long ende2 = System.currentTimeMillis();
        System.out.println("Sortiertes Feld:");
        sd.ausgabe();
        System.out.println("\nBenötigte Zeit: msk: " + (ende2 - start2));
        System.out.println(
                "********************************************************************************************");
        sd = new Sortiere(10);
        sd.initialisiere();
        System.out.println("Bogo Sort");
        System.out.println("Felder: " + sd.werte.length);
        System.out.println("Unsortiertes Feld:");
        sd.ausgabe();
        long start3 = System.currentTimeMillis();
        int aufwand3 = sd.bogoSort();
        long ende3 = System.currentTimeMillis();
        System.out.println("Sortiertes Feld:");
        sd.ausgabe();
        System.out.println("\nBenötigte Zeit: msk: " + (ende3 - start3) + " --> sehr ineffizient!!!");
        System.out.println(
                "********************************************************************************************");
        sd = new Sortiere();
        sd.initialisiere();
        System.out.println("Ripplesort");
        System.out.println("Felder: " + sd.werte.length);
        System.out.println("Unsortiertes Feld:");
        sd.ausgabe();
        long start4 = System.currentTimeMillis();
        int aufwand4 = sd.ripplesort();
        long ende4 = System.currentTimeMillis();
        System.out.println("Sortiertes Feld:");
        sd.ausgabe();
        System.out.println("\nBenötigte Zeit: msk: " + (ende2 - start2));
    }
}
