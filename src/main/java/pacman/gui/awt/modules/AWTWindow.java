package pacman.gui.awt.modules;

import pacman.gui.awt.Listener.AWTKeyboard;
import pacman.gui.awt.Listener.AWTMouse;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;

public class AWTWindow extends Frame {

    private boolean closingRequested = false;

    private Canvas canvas;

    private int canvasWidth = 800;

    private int canvasHeight = 600;

    private BufferStrategy bs;

    private AWTKeyboard keyboard;

    private AWTMouse mouse;

    public void init(String title) {
        this.setTitle(title);
        this.setResizable(false);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                closingRequested = true;
            }
        });
        this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                if (canvas != null) {
                    canvas.requestFocusInWindow();
                }
            }
        });
        this.closingRequested = false;
    }

    public void createCanvas(int width, int height) {
        if (this.canvas == null) {
            this.canvas = new Canvas();
            this.add(canvas);
        }
        if (this.canvasWidth != width || this.canvasHeight != height ) {
            this.setVisible(false);
            this.canvasWidth = width;
            this.canvasHeight = height;
            this.canvas.setPreferredSize(new Dimension(this.canvasWidth, this.canvasHeight));
            this.canvas.setMinimumSize(new Dimension(this.canvasWidth, this.canvasHeight));
            this.canvas.setMaximumSize(new Dimension(this.canvasWidth, this.canvasHeight));
            this.pack();
        }

        if (keyboard == null) {
            this.keyboard = new AWTKeyboard();
            this.canvas.addKeyListener(this.keyboard);
        }

        if (mouse == null) {
            this.mouse = new AWTMouse();
            this.canvas.addMouseListener(this.mouse);
            this.canvas.addMouseMotionListener(this.mouse);
        }
    }

    public boolean isClosingRequested() {
        return this.closingRequested;
    }

    public void setClosingRequested(boolean closingRequested) {
        this.closingRequested = closingRequested;
    }

    public Graphics createGraphics() {
        this.bs = this.canvas.getBufferStrategy();
        if (this.bs == null) {
            this.canvas.createBufferStrategy(2);
            this.bs = this.canvas.getBufferStrategy();
            return null;
        }
        return this.bs.getDrawGraphics();
    }

    public int getCanvasWidth() {
        return this.canvasWidth;
    }

    public int getCanvasHeight() {
        return this.canvasHeight;
    }

    public void switchBuffers() {
        if (this.bs != null) {
            this.bs.show();
        }
    }

    public AWTKeyboard getKeyboard() {
        return this.keyboard;
    }

    public AWTMouse getMouse() {
        return this.mouse;
    }

}