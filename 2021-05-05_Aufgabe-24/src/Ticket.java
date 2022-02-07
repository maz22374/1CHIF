/**
 * @author Mazurek David
 * @version 2021-05-05
 */
public class Ticket {

    private String problem = "<unbekannt>", kunde = "<unbekannt>";
    private int bearbeitungsdauer = 10, ticketNummer = 0;
    private boolean dringend = false;

    public Ticket() {
        this("POS1", "1CHIF", 500, false);
    }

    public Ticket(String problem, String kunde, int bearbeitungsdauer, boolean dringend) {
        setProblem(problem);
        setKunde(kunde);
        setBearbeitungsdauer(bearbeitungsdauer);
        setDringend(dringend);
        setTicketNummer(0);
    }

    public String getProblem() {
        return problem;
    }

    public String getKunde() {
        return kunde;
    }

    public int getBearbeitungsdauer() {
        return bearbeitungsdauer;
    }

    public boolean getDringend() {
        return dringend;
    }

    public int getTicketNummer() {
        return ticketNummer;
    }

    public void setProblem(String problem) {
        if (problem != null && !problem.isEmpty())
            this.problem = problem;
    }

    public void setKunde(String kunde) {
        if (kunde != null && !kunde.isEmpty())
            this.kunde = kunde;
    }

    public void setBearbeitungsdauer(int bearbeitungsdauer) {
        if (bearbeitungsdauer > 0)
            this.bearbeitungsdauer = bearbeitungsdauer;
    }

    public void setDringend(boolean dringend) {
        this.dringend = dringend;
    }

    public void setTicketNummer(int ticketNummer) {
        if (this.ticketNummer == 0)
            this.ticketNummer = ticketNummer;
    }

    public void print() {
        if (getTicketNummer() == 0)
            System.out.print("Ticketnummer: noch nicht vergeben");
        else
            System.out.print("Ticketnummer: " + getTicketNummer());

        System.out.println(", dringend: " + (getDringend() ? "ja" : "nein"));

        System.out.println("Kunde:    " + getKunde());
        System.out.println("Problem:  " + getProblem());

        System.out.print("geschätzte Bearbeitungsdauer: ");
        if (getBearbeitungsdauer() >= 60)
            System.out.print(getBearbeitungsdauer() / 60 + "h ");
        System.out.println(getBearbeitungsdauer() % 60 + "min");
    }
}
