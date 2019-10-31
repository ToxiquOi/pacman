package pacman.state.element;

import org.graalvm.compiler.loop.InductionVariable;
import pacman.state.element.abstracts.StaticElement;
import pacman.state.element.abstracts.WorldIterator;
import pacman.state.element.interfaces.IWorldIterator;

public class World implements Iterable<StaticElement> {

    private int width;
    private int height;

    private StaticElement[][] elements;

    private void init(int[][] level) {

    }

    public void set(int x, int y, StaticElement e) {
        this.elements[x][y] = e;
    }

    public StaticElement get(int x, int y, InductionVariable.Direction d) {
        return null;
    }

    @Override
    public IWorldIterator iterator() {
        return new WorldIterator(this);
    }
}
