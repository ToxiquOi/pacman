package pacman.state.element;


import pacman.state.element.abstracts.StaticElement;
import pacman.state.element.iterators.WorldIterator;
import pacman.state.element.interfaces.IWorldIterator;

public class World implements Iterable<StaticElement> {

    private int width;
    private int height;

    private StaticElement[][] elements;

    private void init(int[][] level) {

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void set(int x, int y, StaticElement e) {
        this.elements[x][y] = e;
    }

    public StaticElement get(int x, int y) {
        return null;
    }

    @Override
    public IWorldIterator iterator() {
        return new WorldIterator(this);
    }
}
