package pacman.state.element;


import pacman.state.element.abstracts.Element;
import pacman.state.element.factory.ElementFactory;
import pacman.state.element.static_element.abstracts.StaticElement;
import pacman.state.element.iterators.WorldIterator;
import pacman.state.element.interfaces.IWorldIterator;
import pacman.state.enumerations.EDirection;

public class World implements Iterable<StaticElement> {

    private int width;
    private int height;

    private ElementFactory factory;
    private StaticElement[][] elements;

    public World(int width, int height) {
        this.width = width;
        this.height = height;
        this.elements = new StaticElement[width][height];
    }

    public void init(int[][] level) {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                Element element = this.factory.create(level[y][x]);
                this.elements[x][y] = (StaticElement) element;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setFactory(ElementFactory factory) {
        this.factory = factory;
    }

    public void set(int x, int y, StaticElement e) {
        this.elements[x][y] = e;
    }

    public StaticElement get(int x, int y, EDirection d) {
        return null;
    }

    @Override
    public IWorldIterator iterator() {
        return new WorldIterator(this);
    }
}
