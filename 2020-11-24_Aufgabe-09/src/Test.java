/**
 * @author Mazurek David
 * @version 2020-11-24
 */
public class Test {

    public static void testen() {
        Taxi taxi1 = new Taxi();
        taxi1.einsteigen(2);
        taxi1.printInfo();
        System.out.println("--------------");
        Taxiunternehmen txu = new Taxiunternehmen(taxi1);
        txu.printInfo();
    }

    public static void testeTaxi() {
        Taxi taxi = new Taxi();
        taxi.printInfo();
    }

    public static void testeTaxiunternehmen() {
        Taxiunternehmen taxiunternehmen = new Taxiunternehmen();
        taxiunternehmen.hinzufuegen(new Taxi());
        taxiunternehmen.printInfo();
    }

    public static void main(String[] args) {
        testeTaxiunternehmen();
    }
}
