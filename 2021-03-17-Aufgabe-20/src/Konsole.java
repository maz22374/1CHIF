import java.util.*;

/**
 * @author Mazurek David
 * @version 2021-03-17
 */
public class Konsole {

    private Scanner eingabe;
    private Zahlenraten spiel;

    public Konsole() {
        this.eingabe = new Scanner(System.in);
        this.spiel = new Zahlenraten();
    }

    public static void main(String[] args) {
        Konsole konsole = new Konsole();
        System.out.println("Geben Sie eine Obergrenze ein:");
        int zhl = konsole.eingabe.nextInt();
        System.out.println("Die zu erratende Zahl liegt zwischen 0 und " + zhl);
        konsole.sleep();
        konsole.spiel.generiereZufallszahl(zhl);
        System.out.println("Geben Sie eine Zahl ein!");
        zhl = konsole.zahlEinlesen();
        while (zhl != konsole.spiel.zahl) {
            System.out.println("Geben Sie eine Zahl ein!");
            switch (konsole.spiel.rateZahl(zhl)) {
                case 1:
                    System.out.println("Zahl zu groß!");
                    zhl = konsole.zahlEinlesen();
                    break;
                case -1:
                    System.out.println("Zahl zu klein!");
                    zhl = konsole.zahlEinlesen();
                    break;
            }
        }
        if (konsole.spiel.rateZahl(zhl) == 0) {
            konsole.sleep();
            System.out.println("RICHTIG");
            konsole.sleep();
            System.out.println("Sie haben " + konsole.spiel.getVersuche() + " Versuche benötigt.");
            konsole.weiterspielen();
        }
    }

    private int zahlEinlesen() {
        int ez = 0;
        boolean eingabeOK = false;
        do {
            if (eingabe.hasNextInt()) {
                ez = eingabe.nextInt();
                eingabeOK = true;
            } else {
                String txt = eingabe.next();
                System.out.print("\"" + txt + "\" ist keine gültige Zahl, bitte noch einmal eingeben: ");
            }
        } while (!eingabeOK);
        return ez;
    }

    private void weiterspielen() {
        System.out.println("Willst du nocheinmal spielen? - Ja / Nein");
        String wort = eingabe.next();
        sleep();
        String wort2 = wort.toLowerCase();
        switch (wort2) {
            case "ja":
                main(null);
            case "nein":
                break;
            default:
                System.out.println("Bitte gültige Zahl nur eingeben!");
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
