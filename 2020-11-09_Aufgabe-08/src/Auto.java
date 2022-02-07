/**
 * @author Mazurek David
 * @version 2020-11-09
 */
public class Auto {

    private float normverbrauch, tankinhalt;
    private int fassungsvermoegen, kilometerstand;
    private String kennzeichen;

    public Auto() {
        setNormverbrauch(4.9f);
        setFassungsvermoegen(50);
        setTankinhalt(33.5f);
        setKilometerstand(40000);
        setKennzeichen("AT 1234 WIE");
    }

    public Auto(float normverbrauch, int tankinhalt, int fassungsvermoegen, int kilometerstand, String kennzeichen) {
        setNormverbrauch(normverbrauch);
        setFassungsvermoegen(fassungsvermoegen);
        setTankinhalt(tankinhalt);
        setKilometerstand(kilometerstand);
        setKennzeichen(kennzeichen);
    }

    public float getNormverbrauch() {
        return normverbrauch;
    }

    public void setNormverbrauch(float normverbrauch) {
        if (normverbrauch >= 1)
            this.normverbrauch = normverbrauch;
        else {
            System.err.println("Ungültiger Wert 'normverbrauch' --> Default");
            setNormverbrauch(4.9f);
        }
    }

    public float getTankinhalt() {
        return tankinhalt;
    }

    public void setTankinhalt(float tankinhalt) {
        if (tankinhalt >= 0 && tankinhalt <= this.fassungsvermoegen)
            this.tankinhalt = tankinhalt;
        else {
            System.err.println("Ungültiger Wert 'tankinhalt' --> Default");
            setTankinhalt(33.5f);
        }
    }

    public int getFassungsvermoegen() {
        return fassungsvermoegen;
    }

    public void setFassungsvermoegen(int fassungsvermoegen) {
        if (fassungsvermoegen >= 1)
            this.fassungsvermoegen = fassungsvermoegen;
        else {
            System.err.println("Ungültiger Wert 'fassungsvermoegen' --> Default");
            setTankinhalt(50f);
        }
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    public void setKilometerstand(int kilometerstand) {
        if (kilometerstand >= 1)
            this.kilometerstand = kilometerstand;
        else {
            System.err.println("Ungültiger Wert 'kilometerstand' --> Default");
            setKilometerstand(40000);
        }
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        if (kennzeichen == null)
            this.kennzeichen = null;
        else if (!kennzeichen.isBlank() && kennzeichen.length() >= 6)
            this.kennzeichen = kennzeichen;
        else {
            System.err.println("Ungültiger Wert 'kennzeichen' --> Default");
            setKennzeichen("Unbekannt");
        }
    }

    public float getRestreichweite() {
        return this.tankinhalt / this.normverbrauch;
    }

    public float tanken() {
        if (tankinhalt != fassungsvermoegen) {
            float f = fassungsvermoegen - tankinhalt;
            setTankinhalt(tankinhalt + f);
            return f;
        } else
            System.err.println("Auto ist vollgetankt");
        return 0;
    }

    public float tanken(float preis, float liter) {
        if (this.tankinhalt + liter <= this.fassungsvermoegen) {
            setTankinhalt(tankinhalt + liter);
            return preis * liter;
        } else
            System.err.println("Zu viel Treibstoff vorhanden");
        return 0;
    }

    public float tanken(float preis, int betrag) {
        float f = betrag / preis;
        if (f + this.tankinhalt <= this.fassungsvermoegen) {
            setTankinhalt(tankinhalt + f);
            return f;
        } else
            System.err.println("Zu viel Treibstoff vorhanden");
        return 0;
    }

    public int fahren() {
        setKilometerstand(this.kilometerstand + (int) (this.tankinhalt / this.normverbrauch));
        return (int) (this.tankinhalt / this.normverbrauch);
    }

    public int fahren(int strecke) {
        if (strecke > this.tankinhalt / this.normverbrauch)
            System.err.println("Du kannst nicht so weit fahren");
        else {
            setKilometerstand(this.kilometerstand + strecke);
            setTankinhalt(this.tankinhalt - (strecke / this.normverbrauch));
            return strecke;
        }
        return 0;
    }

    public void printInfo() {
        System.out.println("Normverbrauch: " + getNormverbrauch());
        System.out.println("aktueller Tankinhalt: " + getTankinhalt() +
                " / Fassungsvermögen: " + getFassungsvermoegen());
        System.out.println("Kilometerstand: " + getKilometerstand() + "km");
        if (getKennzeichen() != null && getKennzeichen().contains("TX"))
            System.out.println("Kennzeichen: " + getKennzeichen() + " - als Taxi angemeldet");
        else if (getKennzeichen() == null)
            System.out.println("Kennzeichen: Auto nicht angemeldet");
        else
            System.out.println("Kennzeichen: " + getKennzeichen());
    }
}
