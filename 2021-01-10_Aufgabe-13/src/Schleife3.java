/**
 * @author Mazurek David
 * @version 2021-01-10
 */
public class Schleife3 {

    public void ausgabeFolge(int zahl) {
        for (int i = 1; i < zahl + 1; i++) {
            System.out.print(i);
            System.out.print(zahl);
            zahl--;
        }
    }

    public void simuliereUhr(int vonStunde, int vonMinute, int bisStunde, int bisMinute) {
        int n = vonMinute;
        while (vonStunde != bisStunde + 1 && vonMinute != bisMinute + 1) {
            if (n == 60) {
                vonStunde++;
                vonMinute = 0;
                n = 0;
            }
            if (n < 10)
                System.out.println(vonStunde + ":0" + vonMinute);
            else
                System.out.println(vonStunde + ":" + vonMinute);
            vonMinute++;
            n++;
        }
    }

    public void zeichneRechteckVoll(int hoehe, int breite) {
        for (int i = 0; i < hoehe; i++) {
            for (int j = 0; j < breite; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public void zeichneRechteckVoll(int hoehe, int breite, String zeichen) {
        for (int i = 0; i < hoehe; i++) {
            for (int j = 0; j < breite; j++) {
                System.out.print(zeichen);
            }
            System.out.println();
        }
    }

    public void zeichneRechteckLeer(int hoehe, int breite, int abstand) {
        for (int zeile = 1; zeile <= hoehe; zeile++) {
            for (int i = 0; i < abstand; i++) {
                System.out.print(" ");
            }
            if (zeile == 1 || zeile == hoehe) {
                for (int b = 1; b <= breite; b++) {
                    System.out.print('*');
                }
            } else {
                System.out.print('*');
                for (int b = 1; b <= breite - 2; b++) {
                    System.out.print(' ');
                }
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void zeichne3Quadrate(int seite) {
        zeichneRechteckLeer(seite, seite, 0);
        zeichneRechteckLeer(seite, seite, 2);
        zeichneRechteckLeer(seite, seite, 0);
    }


    public void zeichenDreieck(int hoehe, boolean leer) {
        if (!leer) {
            for (int zeile = 1; zeile <= hoehe; zeile++) {
                for (int spalte = 1; spalte <= hoehe; spalte++) {
                    if (zeile <= spalte) {
                        System.out.print('*');
                    } else {
                        System.out.print(' ');
                    }
                }
                System.out.println();
            }
        } else {
            for (int i = 1; i <= hoehe; ++i) {
                for (int j = 1; j <= hoehe; ++j) {
                    if (i <= j) {
                        if (i == 1 || j == hoehe || j <= i) {
                            System.out.print('*');
                        } else
                            System.out.print(' ');
                    } else
                        System.out.print(' ');
                }
                System.out.println();
            }
        }
    }

    public void zeichneDreieckPlusMinus(int hoehe) {
        for (int h = 0; h < hoehe; h++) {
            for (int l = 0; l < (hoehe - h - 1); l++) {
                System.out.print(" ");
            }
            for (int l = 0; l < h * 2 + 1; l++) {
                if (l % 2 == 1) {
                    System.out.print("-");
                } else {
                    System.out.print("+");
                }
            }
            for (int l = 0; l < (hoehe - h - 1); l++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void zeichneParallelogramm(int hoehe, int breite, boolean leer) {
        if (!leer) {
            for (int zeile = 1; zeile <= hoehe; zeile++) {
                for (int i = hoehe; i >= zeile; --i) {
                    System.out.print(" ");
                }
                for (int b = 1; b <= breite; b++) {
                    System.out.print('○' + " ");
                }
                System.out.println();
            }
        } else {
            for (int zeile = 1; zeile <= hoehe; zeile++) {
                for (int i = hoehe; i >= zeile; --i) {
                    System.out.print(" ");
                }
                if (zeile == 1 || zeile == hoehe) {
                    for (int b = 1; b <= breite; b++) {
                        System.out.print('○');
                    }
                } else {
                    System.out.print('○');
                    for (int b = 1; b <= breite - 1; b++) {
                        System.out.print(' ');
                    }
                    System.out.print('○');
                }
                System.out.println();
            }
        }
    }

    public void zeichneFunktion(int anz) {
        int maxWert = f1(anz);
        for (int y = 0; y <= maxWert; y++) {
            if (y % 10 != 0) System.out.print(" ");
            else System.out.print(y / 10 % 10);
        }
        System.out.println();
        for (int y = 0; y <= maxWert; y++) {
            System.out.print(y % 10);
        }
        System.out.println();
        for (int x = 1; x <= anz; x++) {
            System.out.print(x);
            int y = f1(x);
            for (int leer = 1; leer < y; leer++) {
                System.out.print(" ");
            }
            System.out.println("*");
        }
    }

    private int f1(int x) {
        int y = 3 * x + 2;
        return y;
    }
}
