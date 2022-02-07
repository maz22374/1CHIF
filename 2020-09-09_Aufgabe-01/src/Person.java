/**
 * @author Mazurek David
 * @version 2020-09-09
 */
public class Person {

    private String name;
    private int geburtsjahr;
    private boolean brille;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
    }

    public boolean getBrille() {
        return brille;
    }

    public void setBrille(boolean brille) {
        this.brille = brille;
    }

    public int berechneAlter() {
        return 2020 - this.geburtsjahr;
    }

    public int berechneAlter(int aktuellesJahr) {
        return aktuellesJahr - this.geburtsjahr;
    }

    public void printInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Brille: " + getBrille());
        System.out.println("Geburtsjahr: " + getGeburtsjahr());
        System.out.println("Alter: " + berechneAlter(2018));
    }
}
