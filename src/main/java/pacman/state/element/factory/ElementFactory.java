package pacman.state.element.factory;

import pacman.share.abstracts.Factory;
import pacman.state.element.abstracts.Element;
import pacman.state.element.static_element.Space;
import pacman.state.element.static_element.Wall;
import pacman.state.enumerations.ESpaceTypeId;
import pacman.state.enumerations.EWallTypeId;


public class ElementFactory extends Factory<Integer, ElementCreator, Element> {
    public static ElementFactory getDefault() {
        ElementFactory factory = new ElementFactory();
        factory.register(0, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.UNKNOWN);
            }
        });
        factory.register(1, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.UNKNOWN);
            }
        });
        factory.register(2, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.EMPTY);
            }
        });
        factory.register(3, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.GUM);
            }
        });
        factory.register(4, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.SUPERGUM);
            }
        });
        factory.register(5, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.SUPERGUM);
            }
        });

        factory.register(11, new ElementCreator() {
            @Override
            public Element create() {
                return new Wall(EWallTypeId.HORIZONTAL);
            }
        });
        factory.register(12, new ElementCreator() {
            @Override
            public Element create() {
                return new Wall(EWallTypeId.VERTICAL);
            }
        });
        factory.register(13, new ElementCreator() {
            @Override
            public Element create() {
                return new Wall(EWallTypeId.BOTTOMLEFT);
            }
        });
        factory.register(14, new ElementCreator() {
            @Override
            public Element create() {
                return  new Wall(EWallTypeId.BOTTOMRIGHT);
            }
        });
        factory.register(15, new ElementCreator() {
            @Override
            public Element create() {
                return new Wall(EWallTypeId.TOPLEFT);
            }
        });
        factory.register(16, new ElementCreator() {
            @Override
            public Element create() {
                return new Wall(EWallTypeId.TOPRIGHT);
            }
        });

        factory.register(21, new ElementCreator() {
            @Override
            public Element create() {
                return new Space(ESpaceTypeId.START);
            }
        });
        for (int i=22;i<=25;i++) {
            factory.register(i, new ElementCreator() {
                @Override
                public Element create() {
                    return new Space(ESpaceTypeId.GRAVEYARD);
                }
            });
        }
        return factory;
    }

}
