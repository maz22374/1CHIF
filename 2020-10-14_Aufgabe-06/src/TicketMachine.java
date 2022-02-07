/**
 * @author Mazurek David
 * @version 2020-10-14
 */
public class TicketMachine {

    private int price, balance, total;
    private boolean child, bike;

    public TicketMachine(int ticketCost) {
        this.price = ticketCost;
    }

    public int getPrice() {
        return this.price;
    }

    public int getBalance() {
        return this.balance;
    }

    public boolean getChild() {
        return child;
    }

    public boolean getBike() {
        return bike;
    }

    public void insertMoney(int amount) {
        if (amount >= 1)
            balance += amount;
        else
            System.err.println("Ungültiger Wert 'amount'.");
    }

    public void printTicket() {
        if (balance >= price) {
            if (getChild()) {
                if (balance >= price / 2) {
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + getPrice() / 2 + " cents.");
                    System.out.println("##################");
                    total = price / 2;
                    balance -= price / 2;
                } else
                    System.err.println("Nicht genügend Geld für ein Ticket.");
            } else if (getBike()) {
                if (balance >= price * 2) {
                    System.out.println("##################");
                    System.out.println("# The BlueJ Line");
                    System.out.println("# Ticket");
                    System.out.println("# " + getPrice() * 2 + " cents.");
                    System.out.println("##################");
                    total = price * 2;
                    balance -= price * 2;
                } else
                    System.err.println("Nicht genügend Geld für ein Ticket.");
            } else {
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + getPrice() + " cents.");
                System.out.println("##################");
                total = price;
                balance -= price;
            }
        } else
            System.err.println("Nicht genügend Geld für ein Ticket.");
    }

    public int refundBalance() {
        int n = this.balance;
        this.balance = 0;
        return n;
    }

    public int empty() {
        int n = this.total;
        this.total = 0;
        return n;
    }
}
