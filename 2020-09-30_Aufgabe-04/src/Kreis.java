/**
 * @author Mazurek David
 * @version 2020-09-30
 */
public class Kreis {

    private double radius;

    public Kreis() {
        setRadius(25);
    }

    public Kreis(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double berechneUmfang() {
        return 2 * radius * Math.PI;
    }

    public double berechneFlaeche() {
        return Math.PI * Math.pow(getRadius(), 2);
    }

    public void printInfo() {
        System.out.println("Radius = " + getRadius());
        System.out.println("Umfang = " + berechneUmfang());
        System.out.println("Fläche = " + berechneFlaeche());
    }
}
