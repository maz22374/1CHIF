/**
 * @author Mazurek David
 * @version 2020-11-04
 */
public class Thermometer {

    private int untergrenze = -38, obergrenze = 50, bisherigesMinimum, bisherigesMaximum, temperatur;

    public Thermometer() {
        this.untergrenze = -38;
        this.obergrenze = 50;
        this.bisherigesMinimum = -5;
        this.bisherigesMaximum = 15;
        this.temperatur = 20;
    }

    public int getTemperatur() {
        return this.temperatur;
    }

    public int getBisherigesMinimum() {
        return this.bisherigesMinimum;
    }

    public int getBisherigesMaximum() {
        return this.bisherigesMaximum;
    }

    public void resetMinMax() {
        this.bisherigesMinimum = -5;
        this.bisherigesMaximum = 15;
    }

    public void aendereTemperatur(int neueTemperatur) {
        if (neueTemperatur >= this.untergrenze && neueTemperatur <= this.obergrenze) {
            this.temperatur = neueTemperatur;
            if (neueTemperatur < this.bisherigesMinimum) {
                System.out.println("Es ist kälter geworden");
                System.out.println("Es ist um " + (neueTemperatur - this.bisherigesMinimum) + "Grad gesunken");
                this.bisherigesMinimum = neueTemperatur;
            } else if (neueTemperatur > this.bisherigesMaximum) {
                System.out.println("Es ist wärmer geworden");
                System.out.println("Es ist um " + (neueTemperatur - this.bisherigesMaximum) + "Grad gestiegen");
                this.bisherigesMaximum = neueTemperatur;
            }
        }
    }

    public void prinInfo() {
        System.out.println("aktuelle Temperatur: " + this.temperatur);
        System.out.println("bisheriges Minimum: " + this.bisherigesMinimum);
        System.out.println("bisheriges Maximum: " + this.bisherigesMaximum);
        if (this.temperatur < 4) {
            System.out.println("Achtung Glatteisgefahr!");
        }
    }
}
