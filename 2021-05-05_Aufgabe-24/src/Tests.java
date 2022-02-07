/**
 * @author Mazurek David
 * @version 2021-05-05
 */
public class Tests {

    private static final String ls = System.lineSeparator();
    private Ticket testTicket1, testTicket2, testTicket3, testTicket4, testTicket5;
    private Support support1;

    public void starteAlleTests() {
        testeTicketGetUndSetMethoden();
        testeSupportTicketsHinzufuegen();
        testeSupportTicketsEntfernen();
        testeSupportFuerKunde();
        testeSupportTicketsSortiertNachBearbeitungsdauer();
    }

    public void testeTicketGetUndSetMethoden() {
        System.out.println(ls + "======== Teste Ticket - get- & set- Methoden, sowie Konstruktoren: ");
        System.out.println(ls + "---- Ticket mit Default-Werten wird erstellt (parameterloser Konstruktor):");
        Ticket tA = new Ticket();
        tA.print();
        System.out.println(ls + "---- Ticket mit neuen korrekten Werten belegen (set-Methoden-Test):");
        tA.setProblem("teste Ändern der Problembeschreibung");
        tA.setKunde("SCG");
        tA.setBearbeitungsdauer(111);
        tA.setDringend(true);
        tA.setTicketNummer(1);
        tA.setTicketNummer(2);
        tA.print();
        System.out.println(ls + "---- Ticket mit bestimmten Übergabewerten wird erstellt (Konstruktor mit Parameter):");
        Ticket tB = new Ticket("Test des zweiten Konstruktors", "SCG", 222, true);
        tB.print();
    }

    public void init() {
        testTicket1 = new Ticket("gelieferter Laptop startet nicht", "Max Mustermann", 15, false);
        testTicket2 = new Ticket("Lieferung unvollständig, weiterer Zusammenbau des Gerätes nicht möglich", "Daniel Düsentrieb", 20, true);
        testTicket3 = new Ticket("Handtasche entspricht nicht der Beschreibung im Katalog, Rücksendung gewünscht", "Susi Sorglos", 10, false);
        testTicket4 = new Ticket("Liefertermin mehr als eine Woche überschritten", "Botique Karla", 5, true);
        testTicket5 = new Ticket("Jacke in falscher Farbe bestellt", "Botique Karla", 5, false);
        support1 = new Support(6);
        support1.ticketHinzufuegen(testTicket1);
        support1.ticketHinzufuegen(testTicket2);
        support1.ticketHinzufuegen(testTicket3);
        support1.ticketHinzufuegen(testTicket4);
        support1.ticketHinzufuegen(testTicket5);
    }

    public void testeSupportTicketsHinzufuegen() {
        System.out.println(ls + "======== Teste Support - Hinzufügen von Tickets");
        System.out.println(ls + "---- neue Warteschlange mit 5 Tickets wird erstellt und ausgegeben ...");
        init();
        System.out.println("---> aktuelle Anzahl von Tickets in Bearbeitung: " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);   // false ... alle Tickets werden ausgegeben

        System.out.println(ls + "---- Versuch ein Ticket (mit schon gesetzter Ticketnummer) nochmals hinzuzufügen:");
        System.out.println("erfolgreich: " + support1.ticketHinzufuegen(testTicket1));

        System.out.println(ls + "---- Versuch zwei weitere Tickets hinzuzufügen, obwohl nur mehr für eines Platz ist:");
        Ticket ticketOk = new Ticket("Ticket für den letzten verfügbaren Platz in der Warteschlange", null, 0, false);
        Ticket ticketFail = new Ticket("Ticket das nicht mehr Platz findet in der Warteschlange", null, 0, false);
        System.out.println("erfolgreich: " + support1.ticketHinzufuegen(ticketOk));
        System.out.println("erfolgreich: " + support1.ticketHinzufuegen(ticketFail));

        System.out.println(ls + "---> aktuelle Anzahl von Tickets in Bearbeitung: " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);

        System.out.println("---- durchschnittliche Bearbeitsungsdauer: ~" + Math.round(support1.durchschnittlicheArbeitszeit()) + "min");
    }

    public void testeSupportTicketsEntfernen() {
        System.out.println(ls + "======== Teste Support - Entfernen von Tickets");
        System.out.println(ls + "---- neue Warteschlange mit 5 Tickets wird erstellt, davon 2 und 4 als dringende Tickets ...");
        init();

        System.out.println(ls + "---- erstes Ticket in der Warteschlange wird entfernt:");
        support1.ticketEntfernen().print();
        System.out.println("---- erstes Ticket in der Warteschlange wird entfernt:");
        support1.ticketEntfernen().print();

        System.out.println(ls + "---> aktuelle Anzahl von Tickets in Bearbeitung: " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);

        System.out.println(ls + "---- erstes DRINGENDE Ticket in der Warteschlange wird entfernt:");
        support1.dringendesTicketEntfernen().print();
        System.out.println(ls + "---> aktuelle Anzahl von Tickets in Bearbeitung: " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);
    }

    public void testeSupportFuerKunde() {
        System.out.println(ls + "======== Teste Support - kundenbezogene Methoden");
        System.out.println(ls + "---- neue Warteschlange mit 5 Tickets wird erstellt, davon 4 & 5 für \"Botique Karla\" ...");
        init();

        System.out.println(ls + "---- gesamte Bearbeitungsdauer für Kunde \"Botique Karla\":");
        System.out.println("berechnete Dauer: " + support1.arbeitszeitFuerKunde("Botique Karla") + "min");

        System.out.println(ls + "---- Array mit Referenzen auf Tickets eines Kunden:");
        Ticket[] karla = support1.ticketsFuerKunde("Botique Karla");
        System.out.println("es wurden folgende Einträge für \"Botique Karla\" gefunden:");
        for (int i = 0; i < karla.length; i++) {
            karla[i].print();
        }

        System.out.println(ls + "---- entferne alle Ticktes für Kunde \"Botique Karla\":");
        System.out.println("Anzahl entfernter Einträge: " + support1.entferneAlleTickets("Botique Karla"));

        System.out.println(ls + "---> aktuelle Anzahl von Tickets in Bearbeitung: " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);
    }

    public void testeSupportTicketsSortiertNachBearbeitungsdauer() {
        System.out.println(ls + "======== Teste Support - Sortieren von Tickets");
        init();
        System.out.println(ls + "---- neue Warteschlange mit 5 Tickets wird erstellt und ausgegeben ...");

        System.out.println(ls + "---> aktuelle Anzahl von Tickets in Bearbeitung (unsortiert): " + support1.anzahlTicketsInBearbeitung());
        support1.print(false);

        System.out.println(ls + "---- nach Bearbeitungsdauer Sortierte Ausgabe:");
        support1.printTicketsSortiertNachBearbeitungsdauer();
    }
}