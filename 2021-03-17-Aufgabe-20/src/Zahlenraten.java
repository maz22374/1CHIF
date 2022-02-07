import java.util.*;

/**
 * @author Mazurek David
 * @version 2021-03-17
 */
public class Zahlenraten {

    private Random generator;
    public int zahl, versuche;

    public Zahlenraten() {
        generator = new Random();
    }

    public void generiereZufallszahl(int max) {
        zahl = generator.nextInt(max);
        versuche = 0;
    }

    public int rateZahl(int zahl) {
        if (this.zahl == zahl) {
            versuche++;
            System.out.println(zahl + "... die Zahl wurde erraten");
            return 0;
        } else if (this.zahl < zahl) {
            versuche++;
            System.out.println(zahl + "... die übergebene Zahl war größer");
            return 1;
        } else if (this.zahl > zahl) {
            versuche++;
            System.out.println(zahl + "... die übergebene Zahl war kleiner");
        }
        return -1;
    }

    public int getVersuche() {
        return versuche;
    }
}
