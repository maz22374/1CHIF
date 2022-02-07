# Aufgabe 05: (als Ergänzung zu den Aufgaben 03 und 04)

### Teil 1)
- Erstelle eine Kopie des Projekts „Aufgabe 04“ und nenne es „Aufageb 05“.
- Falls Du nicht ohnehin bereits mit „this“ arbeitest, ändere die set-Methoden der Klassen
Rechteck und Kreis so, dass die Übergaberparamter die gleichen Namen verwenden wie die
Attribute (überlege wo this. zu verwenden ist)
- Plausibilitätschecks: Ändere die set-Methoden für laenge, breite und radius so, dass sie nur
bestimmte Wertebereiche erlauben, im Fehlerfall eine Meldung auf die Konsole ausgeben
und einen Standardwert setzen.

Es soll gelten:
> 1 <= laenge <= 100 ... Standardwert: 10

> 1 <= breite <= 50 ... Standardwert: 5

> 0.1 <= radius <= 10.0 ... Standardwert: 1.0

### Teil 2)
- Kopiere Deine Flugzeug-Klasse in das Projekt „Aufgabe 05“ und erweitere sie um
Plausibilitätschecks für alle Attribute die eine Zahl oder einen Text als Datentypen
verwenden.
- Überlege Dir plausible Unter- und Obergrenzen für Zahlenwerte z.B.:
geschwindigkeit, gewicht, treibstoffmenge, anzahlPassagiere, fluegelspannweite,...
- und stelle sicher, dass Text-Attribute einen Text ungleich der null-Referenz mit einer
bestimmten Mindestanzahl von Buchstaben erhalten
(*length()*-Methode der Klasse *String*)
