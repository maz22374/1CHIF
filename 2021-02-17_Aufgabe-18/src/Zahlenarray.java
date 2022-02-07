import java.util.Random;
import java.util.Scanner;

/**
 * @author Mazurek David
 * @version 2021-02-17
 */
public class Zahlenarray {

    private float[] werte;
    private int freiePos;
    private float minWert = -100, maxWert = 500;

    public Zahlenarray() {
        setMinMaxWerte(-100, 500);
        werte = new float[10];
        freiePos = 0;
    }

    public Zahlenarray(int groesse, float minWert, float maxWert) {
        setMinMaxWerte(minWert, maxWert);
        if (groesse < 0) {
            groesse = 10;
            System.err.println("Ungültige Array-Größe, es wird der Standardwert " + groesse + " verwendet");
        }
        werte = new float[groesse];
        freiePos = 0;
    }


    public float getMinWert() {
        return minWert;
    }

    public float getMaxWert() {
        return maxWert;
    }

    private void setMinWert(float minWert) {
        if (minWert >= -100.0 && minWert <= maxWert) {
            this.minWert = minWert;
        } else {
            System.err.println("Ungültige Untergrenze, es wird -100 verwndet!");
            this.minWert = -100;
        }
    }

    private void setMaxWert(float maxWert) {
        if (maxWert <= 500.0 && maxWert >= minWert) {
            this.maxWert = maxWert;
        } else {
            System.err.println("Ungültige Obergrenze es wird 500 verwendet!");
            this.maxWert = 500;
        }
    }

    private void setMinMaxWerte(float minWert, float maxWert) {
        if (minWert >= -100.0 && maxWert <= 500.0 && minWert <= maxWert) {
            this.minWert = minWert;
            this.maxWert = maxWert;
        } else {
            System.err.println("Ungültige Unter- oder Obergrenze es werden die Werte -100 und 500 verwendet!");
            this.minWert = -100;
            this.maxWert = 500;
        }
    }

    public void ausgeben() {
        if (freiePos <= 0) {
            System.out.println("keine Werte vorhanden");
        } else {
            System.out.println("Das Array enthält " + freiePos + ((freiePos == 1) ? " Wert:" : " Werte:"));
            for (int i = 0; i < freiePos; i++) {
                System.out.println("werte[" + i + "] = " + werte[i]);
            }
        }
    }

    public boolean einfuegen(float wert) {
        boolean erfolg = true;
        if (wert <= maxWert && wert >= minWert) {
            if (freiePos < werte.length) {
                werte[freiePos] = wert;
                freiePos++;
            } else {
                erfolg = false;
                System.err.println("Das Array ist bereits voll!");
            }
        } else {
            erfolg = false;
            System.err.println("Der Wert " + wert + " liegt nicht im gültigen Wertebereich!");
        }
        return erfolg;
    }

    public boolean einfuegen(float wert, int pos) {
        boolean erfolg = false;
        if (wert > maxWert || wert < minWert) {
            System.err.println("Der Wert liegt nicht im gültigen Wertebereich!");
        } else if (freiePos >= werte.length) {
            System.err.println("Das Array ist bereits voll!");
        } else if (pos < 0 || pos > freiePos) {
            System.err.println("An der angegebenen Stelle darf nicht eingefügt werden!");
        } else {
            for (int i = freiePos; i > pos; i--) {
                werte[i] = werte[i - 1];
            }
            werte[pos] = wert;
            freiePos++;
            erfolg = true;
        }
        return erfolg;
    }

    public void zufallszahlen(float min, float max) {
        if (min > max) {
            float temp = min;
            min = max;
            max = temp;
        }

        float korrMin = Math.max(min, minWert);
        float korrMax = Math.min(max, maxWert);
        freiePos = 0;

        Random r = new Random();
        for (int i = 0; i < werte.length; i++) {
            werte[i] = korrMin + r.nextFloat() * (korrMax - korrMin);
            freiePos++;
        }
    }

    public void einlesen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Einlesen läuft bis zur Eingabe von -999 oder bis das Array voll ist.");

        float eingabe = 0;
        while (eingabe != -999 && freiePos < werte.length) {
            System.out.println("Bitte gewünschte Zahl eingeben:");

            if (sc.hasNextFloat()) {
                eingabe = sc.nextFloat();
                if (eingabe != -999) {
                    einfuegen(eingabe);
                }
            } else {
                System.out.println("Ungültige Eingabe: " + sc.next() + " Bitte die Zahl noch einmal eingeben: ");
            }
        }
        System.out.println("Einlesen beendet.");
    }

    public void einlesen(int anzahl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Einlesen läuft bis zur Eingabe von -999 oder bis das Array voll ist.");

        float eingabe = 0;
        while (anzahl > 0 && freiePos < werte.length) {
            System.out.println("Bitte gewünschte Zahl eingeben:");

            if (sc.hasNextFloat()) {
                eingabe = sc.nextFloat();
                einfuegen(eingabe);
                anzahl--;
            } else {
                System.out.println("Ungültige Eingabe: " + sc.next() + " Bitte die Zahl noch einmal eingeben: ");
            }
        }
        System.out.println("Einlesen beendet.");
    }

    public int anzahl() {
        return freiePos;
    }

    public int anzahlGroesser(float wert) {
        int anzahl = 0;

        for (int i = 0; i < freiePos; i++) {
            if (werte[i] >= wert) {
                anzahl++;
            }
        }
        return anzahl;
    }

    public float[] arrayGroesser(float wert) {
        int anzahl = anzahlGroesser(wert);
        float[] groessereWerte = new float[anzahl];
        for (int i = 0, zaehler = 0; i < freiePos; i++) {
            if (werte[i] >= wert) {
                groessereWerte[zaehler] = werte[i];
                zaehler++;
            }
        }
        return groessereWerte;
    }

    public void tauschen(int pos1, int pos2) {
        if (pos1 >= 0 && pos1 < freiePos && pos2 >= 0 && pos2 < freiePos) {
            float temp = werte[pos1];
            werte[pos1] = werte[pos2];
            werte[pos2] = temp;
        } else {
            System.err.println("Tausch mit ungültigem Index nicht möglich!");
        }
    }

    public boolean entfernen() {
        boolean erfolg = false;
        if (freiePos > 0) {
            freiePos--;
            werte[freiePos] = 0;
            erfolg = true;
        } else {
            System.err.println("Das Array ist leer!");
        }
        return erfolg;
    }

    public boolean entfernen(int pos) {
        if (pos >= 0 && pos < freiePos) {
            for (int i = pos; i < freiePos - 1; i++) {
                werte[i] = werte[i + 1];
            }
            freiePos--;
            werte[freiePos] = 0;
            return true;
        } else {
            System.err.println("Positon ungültig oder Array leer!");
            return false;
        }
    }

    public int suchenPosition(float wert) {
        int index = -1;
        for (int i = 0; i < freiePos; i++) {
            if (werte[i] == wert) {
                index = i;
            }
        }
        return index;
    }

    public boolean entferneLetztesVorkommen(float wert) {
        int pos = this.suchenPosition(wert);
        if (pos == -1) {
            return false;
        } else {
            return entfernen(pos);
        }
    }

    public boolean entferneAlleVorkommen(float wert) {
        boolean erfolg = false;
        while (entferneLetztesVorkommen(wert)) {
            erfolg = true;
        }
        return erfolg;
    }

    public float[] arraySortiert() {
        float[] kopie = new float[freiePos];
        for (int i = 0; i < freiePos; i++) {
            kopie[i] = werte[i];
        }
        boolean getauscht = true;
        for (int d = 0; d < kopie.length - 1 && getauscht; d++) {
            getauscht = false;
            for (int i = 0; i < kopie.length - 1 - d; i++) {
                if (kopie[i] > kopie[i + 1]) {
                    float temp = kopie[i];
                    kopie[i] = kopie[i + 1];
                    kopie[i + 1] = temp;

                    getauscht = true;
                }
            }
        }
        return kopie;
    }
}
