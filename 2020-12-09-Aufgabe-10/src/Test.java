/**
 * @author Mazurek David
 * @version 2020-12-09
 */
public class Test {
    public void testeZug() {
        Personenwagon wagon1 = new Personenwagon(150, 2);
        Personenwagon wagon2 = new Personenwagon(120, 1);
        Personenwagon wagon3 = new Personenwagon(100, 2);

        Zug zug1 = new Zug(wagon1);
        zug1.wagonHinzufuegen(wagon2);
        zug1.wagonHinzufuegen(wagon3);

        System.out.println("Zug:");
        zug1.printInfo();

        System.out.println("-----");

        System.out.println("Sitzplätze 2. Klasse: " + zug1.getAnzahlFreieSitzplaetze(2));
        System.out.println("Sitzplätze gesamt: " + zug1.getAnzahlFreieSitzplaetze(0));

        System.out.println("-----");

        System.out.println("verteile 300 Personen in Wagons der Klasse 2:");
        int uebrig = zug1.verteilen(300, 2);
        System.out.println("übrig bleiben: " + uebrig + " Personen");

        System.out.println("-----");

        System.out.println("Zug:");
        zug1.printInfo();
    }
}
