/**
 * @author Mazurek David
 * @version 2021-05-05
 */
public class Support {

    private Ticket[] tickets;
    private int freiePos;

    public Support(int maxAnfragen) {
        if (maxAnfragen <= 0)
            maxAnfragen = 10;
        tickets = new Ticket[maxAnfragen];
        freiePos = 0;
    }

    public int anzahlTicketsInBearbeitung() {
        return freiePos;
    }

    public boolean ticketHinzufuegen(Ticket t) {
        if (t == null || t.getTicketNummer() != 0 || freiePos >= tickets.length)
            return false;

        if (freiePos == 0)
            t.setTicketNummer(1);
        else {
            int maxNummer = tickets[0].getTicketNummer();
            for (int idx = 1; idx < freiePos; idx++) {
                if (maxNummer < tickets[idx].getTicketNummer()) {
                    maxNummer = tickets[idx].getTicketNummer();
                }
            }
            t.setTicketNummer(maxNummer + 1);
        }
        tickets[freiePos] = t;
        freiePos++;
        return true;
    }

    public Ticket ticketEntfernen() {
        Ticket entferntesTicket = tickets[0];
        if (freiePos > 0) {
            for (int idx = 0; idx < freiePos - 1; idx++) {
                tickets[idx] = tickets[idx + 1];
            }
            freiePos--;
            tickets[freiePos] = null;
        }
        return entferntesTicket;
    }

    private Ticket ticketEntfernen(int pos) {
        Ticket entferntesTicket = null;

        if (pos >= 0 && pos < freiePos) {
            entferntesTicket = tickets[pos];
            for (int idx = pos; idx < freiePos - 1; idx++) {
                tickets[idx] = tickets[idx + 1];
            }
            freiePos--;
        }
        return entferntesTicket;
    }

    public Ticket dringendesTicketEntfernen() {
        Ticket entferntesTicket = null;
        for (int idx = 0; idx < freiePos; idx++) {
            if (tickets[idx].getDringend()) {
                entferntesTicket = ticketEntfernen(idx);
                break;
            }
        }
        return entferntesTicket;
    }

    public void print(boolean dringend) {
        for (int idx = 0; idx < freiePos; idx++) {
            if (!dringend || tickets[idx].getDringend())
                tickets[idx].print();
        }
    }

    public float durchschnittlicheArbeitszeit() {
        float summe = 0;
        for (int idx = 0; idx < freiePos; idx++) {
            summe += tickets[idx].getBearbeitungsdauer();
        }
        if (freiePos > 0)
            return summe / freiePos;
        else
            return 0;
    }

    public int arbeitszeitFuerKunde(String kunde) {
        int arbeitszeit = 0;
        for (int idx = 0; idx < freiePos; idx++) {
            if (tickets[idx].getKunde().equals(kunde))
                arbeitszeit += tickets[idx].getBearbeitungsdauer();
        }
        return arbeitszeit;
    }

    private int suchePositionTicket(String kunde) {
        int position = -1;
        for (int idx = 0; idx < freiePos; idx++) {
            if (tickets[idx].getKunde().equals(kunde)) {
                position = idx;
                break;
            }
        }
        return position;
    }

    public int entferneAlleTickets(String kunde) {
        int position = -1, anzahl = 0;
        while ((position = suchePositionTicket(kunde)) > -1) {
            ticketEntfernen(position);
            anzahl++;
        }
        return anzahl;
    }

    public Ticket[] ticketsFuerKunde(String kunde) {
        Ticket[] ticketsKunde = null;
        int anzahl = 0;
        for (int idx = 0; idx < freiePos; idx++) {
            if (tickets[idx].getKunde().equals(kunde))
                anzahl++;
        }
        if (anzahl > 0) {
            ticketsKunde = new Ticket[anzahl];

            for (int idx = 0, pos = 0; idx < freiePos; idx++) {
                if (tickets[idx].getKunde().equals(kunde)) {
                    ticketsKunde[pos] = tickets[idx];
                    pos++;
                }
            }
        }
        return ticketsKunde;
    }

    public void printTicketsSortiertNachBearbeitungsdauer() {
        Ticket[] kopie = new Ticket[freiePos];
        for (int idx = 0; idx < freiePos; idx++) {
            kopie[idx] = tickets[idx];
        }
        boolean getauscht = true;
        for (int d = 0; d < kopie.length - 1 && getauscht; d++) {
            getauscht = false;
            for (int i = 0; i < kopie.length - 1 - d; i++) {
                if (kopie[i].getBearbeitungsdauer() > kopie[i + 1].getBearbeitungsdauer()) {
                    Ticket temp = kopie[i];
                    kopie[i] = kopie[i + 1];
                    kopie[i + 1] = temp;
                    getauscht = true;
                }
            }
        }
        for (int i = 0; i < kopie.length; i++) {
            kopie[i].print();
        }
    }
}
