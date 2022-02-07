package Teil1;

/**
 * @author Mazurek David
 * @version 2020-10-07
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
        if (radius >= 0.1 && radius <= 10)
            this.radius = radius;
        else {
            System.err.println("Ungültiger Wert 'radius' --> Default");
            this.radius = 1;
        }
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
