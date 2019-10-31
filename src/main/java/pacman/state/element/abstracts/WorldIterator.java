package pacman.state.element.abstracts;

import pacman.state.element.World;
import pacman.state.element.interfaces.IWorldIterator;

public class WorldIterator implements IWorldIterator {

    private World world;

    int x;
    int y;

    public WorldIterator(World world) {
        this.world = world;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public StaticElement next() {
        return null;
    }
}
