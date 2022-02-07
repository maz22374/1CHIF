import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author David Mazurek
 * @version 2021-06-09
 */
public class ImageLoader {

    static Image imgX, imgO;

    public ImageLoader() {
        try {
            imgX = ImageIO.read(new File("res/x.png"));
            imgO = ImageIO.read(new File("res/o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
