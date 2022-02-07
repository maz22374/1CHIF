/**
 * @author Mazurek David
 * @version 2021-01-13
 */
public class Buchstabieren {

    public void buchstabieren(String wort) {
        System.out.println("Zu buchstabierendes Wort: " + wort);
        for (int i = 0; i < wort.length(); i++) {
            String wort2 = wort.toLowerCase();
            char a = wort2.charAt(i);
            System.out.print(wort.charAt(i) + "...");
            switch (a) {
                case 'a':
                    System.out.println("Alpha");
                    break;
                case 'b':
                    System.out.println("Bravo");
                    break;
                case 'c':
                    System.out.println("Charlie");
                    break;
                case 'd':
                    System.out.println("Delta");
                    break;
                case 'e':
                    System.out.println("Echo");
                    break;
                case 'f':
                    System.out.println("Foxtrot");
                    break;
                case 'g':
                    System.out.println("Golf");
                    break;
                case 'h':
                    System.out.println("Hotel");
                    break;
                case 'i':
                    System.out.println("India");
                    break;
                case 'j':
                    System.out.println("Juliett");
                    break;
                case 'k':
                    System.out.println("Kilo");
                    break;
                case 'l':
                    System.out.println("Lima");
                    break;
                case 'm':
                    System.out.println("Mike");
                    break;
                case 'n':
                    System.out.println("November");
                    break;
                case 'o':
                    System.out.println("Oscar");
                    break;
                case 'p':
                    System.out.println("Papa");
                    break;
                case 'q':
                    System.out.println("Quebec");
                    break;
                case 'r':
                    System.out.println("Romeo");
                    break;
                case 's':
                    System.out.println("Sierra");
                    break;
                case 't':
                    System.out.println("Tango");
                    break;
                case 'u':
                    System.out.println("Uniform");
                    break;
                case 'v':
                    System.out.println("Victor");
                    break;
                case 'w':
                    System.out.println("Whiskey");
                    break;
                case 'x':
                    System.out.println("X-Ray");
                    break;
                case 'y':
                    System.out.println("Yankee");
                    break;
                case 'z':
                    System.out.println("Zulu");
                    break;
                default:
                    System.out.println("?");
            }
        }
    }
}
