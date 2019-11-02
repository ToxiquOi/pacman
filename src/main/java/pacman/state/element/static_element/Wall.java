package pacman.state.element.static_element;

import pacman.state.element.abstracts.Element;
import pacman.state.element.static_element.abstracts.StaticElement;
import pacman.state.enumerations.EWallTypeId;

public class Wall extends StaticElement {
    public Wall(EWallTypeId wallTypeId) {
        this.wallTypeId = wallTypeId;
    }

    EWallTypeId wallTypeId;

    @Override
    public Element create() {
        return null;
    }
}
