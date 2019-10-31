package pacman.gui.awt.modules;

import pacman.gui.interfaces.IImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class AWTImage implements IImage {
    private BufferedImage image;

    @Override
    public int getWidth() {
        if (image == null) {
            throw new RuntimeException("L'image n'a pas été chargée");
        }
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        if (image == null) {
            throw new RuntimeException("L'image n'a pas été chargée");
        }
        return image.getHeight();
    }

    public void loadImage(String fileName) {
        try {
            image = ImageIO.read(this.getClass().getClassLoader().getResource(fileName));
        } catch (IOException ex) {
            throw new RuntimeException("Erreur lors de la lecture de "+fileName);
        }
    }

    public void draw(Graphics graphics, int x, int y) {
        graphics.drawImage(image, x, y, null);
    }

}
