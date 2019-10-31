package pacman.gui.awt;

import pacman.gui.awt.modules.AWTFonts;
import pacman.gui.awt.modules.AWTImage;
import pacman.gui.awt.modules.AWTLayer;
import pacman.gui.awt.modules.AWTWindow;
import pacman.gui.interfaces.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AWTGUIFacade implements IGUIFacade {
    private AWTWindow window;

    private Graphics graphics;

    private AWTFonts fonts;

    public AWTGUIFacade() {
        fonts = new AWTFonts();
    }

    public boolean isClosingRequested() {
        return this.window.isClosingRequested();
    }


    public void setClosingRequested(boolean closingRequested) {
        this.window.setClosingRequested(closingRequested);
    }

    public void dispose() {
        this.window.dispose();
    }

    @Override
    public void createWindow(int width, int height, String title) {
        if (window == null) {
            window = new AWTWindow();
        }
        window.init(title);
        window.createCanvas(width, height);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public boolean beginPaint() {
        if (this.graphics != null) {
            this.graphics.dispose();
        }
        this.graphics = this.window.createGraphics();
        if (this.graphics == null) {
            return false;
        }
        return true;
    }

    public void endPaint() {
        if (this.graphics == null) {
            return;
        }

        this.graphics.dispose();
        this.graphics = null;
        this.window.switchBuffers();
    }

    public void clearBackground() {
        if (this.graphics == null) {
            return;
        }
        this.graphics.setColor(Color.black);
        this. graphics.fillRect(0, 0, window.getCanvasWidth(), window.getCanvasHeight());
    }

    @Override
    public ILayer createLayer() {
        return new AWTLayer();
    }

    @Override
    public void drawLayer(ILayer layer) {
        if (this.graphics == null) {
            return;
        }
        if (layer == null)
            throw new IllegalArgumentException("Pas de layer");
        if (!(layer instanceof AWTLayer))
            throw new IllegalArgumentException("Type de layer invalide");
        AWTLayer awtLayer = (AWTLayer) layer;
        awtLayer.draw(this.graphics);
        //this.saveLayer(awtLayer);
    }

    public void saveLayer(AWTLayer layer) {
        BufferedImage image = new BufferedImage(window.getCanvasWidth(),window.getCanvasHeight(),BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = image.getGraphics();
        layer.draw(g);
        g.dispose();
        try {
            ImageIO.write(image, "png", new File(layer.toString()+".png"));
        } catch (IOException ex) {
            Logger.getLogger(AWTGUIFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public IKeyboard getKeyboard() {
        if (this.window == null)
            throw new RuntimeException("Il faut d'abord créer une fenêtre");
        return this.window.getKeyboard();
    }

    public IMouse getMouse() {
        if (this.window == null)
            throw new RuntimeException("Il faut d'abord créer une fenêtre");
        return this.window.getMouse();
    }

    public IImage createImage(String fileName) {
        AWTImage image = new AWTImage();
        image.loadImage(fileName);
        return image;
    }

    public void drawImage(IImage image,int x,int y) {
        if (this.graphics == null) {
            return;
        }
        if (image == null)
            throw new IllegalArgumentException("Pas de image");
        if (!(image instanceof AWTImage))
            throw new IllegalArgumentException("Type de image invalide");
        AWTImage awtImage = (AWTImage) image;
        awtImage.draw(this.graphics, x, y);
    }

    public void setColor(Color color) {
        if (this.graphics == null)
            return;
        this.graphics.setColor(color);
    }

    public void setTextSize(int size) {
        if (this.graphics == null)
            return;
        this.graphics.setFont(this.fonts.getFont(this.graphics,size));
    }

    @Override
    public Dimension getTextMetrics(String text) {
        FontMetrics fm = this.graphics.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();
        return new Dimension(textWidth,textHeight);
    }

    public void drawText(String text, int x, int y, int width, int height) {
        if (this.graphics == null)
            return;
        FontMetrics fm = this.graphics.getFontMetrics();
        this.graphics.clipRect(x, y, width, height);
        this.graphics.drawString(text, x, y+fm.getAscent());
        this.graphics.setClip(null);
    }

}
