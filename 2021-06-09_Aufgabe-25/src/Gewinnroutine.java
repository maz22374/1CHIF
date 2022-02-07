import java.util.Timer;
import java.util.TimerTask;

/**
 * @author David Mazurek
 * @version 2021-06-09
 */
public class Gewinnroutine {

    private Timer time;

    public Gewinnroutine() {
        time = new Timer();
        time.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                if (Gui.gewinner == 0) {

                    // Reihe 1 für X - Horizontal
                    if (Gui.state[0] == 1 && Gui.state[1] == 1 && Gui.state[2] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Reihe 2 für X - Horizontal
                    else if (Gui.state[3] == 1 && Gui.state[4] == 1 && Gui.state[5] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Reihe 3 für X - Horizontal
                    else if (Gui.state[6] == 1 && Gui.state[7] == 1 && Gui.state[8] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Reihe 1 für X - Vertikal
                    if (Gui.state[0] == 1 && Gui.state[3] == 1 && Gui.state[6] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Reihe 2 für X - Vertikal
                    if (Gui.state[1] == 1 && Gui.state[4] == 1 && Gui.state[7] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Reihe 3 für X - Vertikal
                    if (Gui.state[2] == 1 && Gui.state[5] == 1 && Gui.state[8] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Cross links oben - rechts unten für X
                    if (Gui.state[0] == 1 && Gui.state[4] == 1 && Gui.state[8] == 1) {
                        Gui.gewinner = 1;
                    }

                    // Cross rechts oben - links unten für X
                    if (Gui.state[2] == 1 && Gui.state[4] == 1 && Gui.state[6] == 1) {
                        Gui.gewinner = 1;
                    }

                    ///////////////////////////////////////////////////////////////////

                    // Reihe 1 für Y - Horizontal
                    if (Gui.state[0] == 2 && Gui.state[1] == 2 && Gui.state[2] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Reihe 2 für Y - Horizontal
                    else if (Gui.state[3] == 2 && Gui.state[4] == 2 && Gui.state[5] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Reihe 3 für Y - Horizontal
                    else if (Gui.state[6] == 2 && Gui.state[7] == 2 && Gui.state[8] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Reihe 1 für Y - Vertikal
                    if (Gui.state[0] == 2 && Gui.state[3] == 2 && Gui.state[6] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Reihe 2 für Y - Vertikal
                    if (Gui.state[1] == 2 && Gui.state[4] == 2 && Gui.state[7] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Reihe 3 für Y - Vertikal
                    if (Gui.state[2] == 2 && Gui.state[5] == 2 && Gui.state[8] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Cross links oben - rechts unten für Y
                    if (Gui.state[0] == 2 && Gui.state[4] == 2 && Gui.state[8] == 2) {
                        Gui.gewinner = 2;
                    }

                    // Cross rechts oben - links unten für Y
                    if (Gui.state[2] == 2 && Gui.state[4] == 2 && Gui.state[6] == 2) {
                        Gui.gewinner = 2;
                    }
                }
            }
        }, 0, 150);
    }
}
