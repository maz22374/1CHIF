package Teil2;

/**
 * @author Mazurek David
 * @version 2020-09-23
 */
public class Rechner {

    private int zahl1, zahl2;

    public Rechner() {
        setZahl1(25);
        setZahl2(50);
    }

    public Rechner(int zahl1, int zahl2) {
        setZahl1(zahl1);
        setZahl2(zahl2);
    }

    public int getZahl1() {
        return zahl1;
    }

    public void setZahl1(int zahl1) {
        this.zahl1 = zahl1;
    }

    public int getZahl2() {
        return zahl2;
    }

    public void setZahl2(int zahl2) {
        this.zahl2 = zahl2;
    }

    public int berechnerSumme() {
        return this.zahl1 + this.zahl2;
    }

    public int berechneDifferenz() {
        return this.zahl1 - this.zahl2;
    }

    public int berechneProdukt() {
        return this.zahl1 * this.zahl2;
    }

    public int berechneQuotient() {
        return this.zahl1 / this.zahl2;
    }

    public void printInfo() {
        System.out.println("Zahl1: " + this.zahl1);
        System.out.println("Zahl2: " + this.zahl2);
        System.out.println("--------------------");
        System.out.println("Summe: " + berechnerSumme());
        System.out.println("Differenz: " + berechneDifferenz());
        System.out.println("Produkt: " + berechneProdukt());
        System.out.println("Quotien: " + berechneQuotient());
    }
}
