package pacman.state;

import pacman.state.element.World;

public class State {
    World world;

    public void setWorld(World world) {
        this.world = world;
    }

    public World getWorld() {
        return world;
    }
}
