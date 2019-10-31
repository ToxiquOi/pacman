package pacman.state.element.iterators;

import pacman.state.element.World;
import pacman.state.element.abstracts.StaticElement;
import pacman.state.element.interfaces.IWorldIterator;

import java.util.NoSuchElementException;

public class WorldIterator implements IWorldIterator {

    private World world;

    private int x;
    private int y;

    public WorldIterator(World world) {
        this.world = world;
        this.x = -1;
        this.y = 0;
    }

    @Override
    public World getWorld() {
        return this.world;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public boolean hasNext() {
        if (this.x + 1 < this.world.getWidth()) {
            return true;
        }
        else return this.y + 1 < this.world.getHeight();
    }

    @Override
    public StaticElement next() {
        if(this.x + 1 < this.world.getWidth()) {
            this.x++;
        }
        else if(this.y + 1 < this.world.getHeight()) {
            this.x = 0;
            this.y++;
        }
        else {
            throw new NoSuchElementException("position x: " + this.x + ", y: " + this.y);
        }

        return this.world.get(this.x, this.y);
    }
}
