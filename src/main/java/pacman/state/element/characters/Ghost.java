package pacman.state.element.characters;

import pacman.state.element.abstracts.Element;
import pacman.state.element.characters.abstracts.MobileElement;
import pacman.state.enumerations.EGhostState;

public class Ghost extends MobileElement {
    EGhostState ghostState;

    @Override
    public Element create() {
        return null;
    }
}
