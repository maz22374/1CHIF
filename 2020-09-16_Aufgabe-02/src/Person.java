/**
 * @author Mazurek David
 * @version 2020-09-16
 */
public class Person {

    private String name;
    private boolean brille;
    private int geburtsjahr;

    public Person() {
        setName("Max");
        setBrille(true);
        setGeburtsjahr(2020);
    }

    public Person(String name, boolean brille, int geburtsjahr) {
        setName(name);
        setBrille(brille);
        setGeburtsjahr(geburtsjahr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getBrille() {
        return brille;
    }

    public void setBrille(boolean brille) {
        this.brille = brille;
    }

    public int getGeburtsjahr() {
        return geburtsjahr;
    }

    public void setGeburtsjahr(int geburtsjahr) {
        this.geburtsjahr = geburtsjahr;
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
