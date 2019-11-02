package pacman.mode.menu;

import pacman.mode.PlayGM;
import pacman.mode.abstracts.MenuGameMode;

import java.awt.event.KeyEvent;

public class MainMenuGM extends MenuGameMode {


    public MainMenuGM() {
        this.items.add("Play");
        this.items.add("Unknown");
        this.items.add("Exit");
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void handleInputs() {
        switch (this.keyboard.getLastPressedKey()) {
            case KeyEvent.VK_ESCAPE:
                this.keyboard.consumeLastPressedKey();
                this.gui.setClosingRequested(true);
                break;

            case KeyEvent.VK_UP:
                this.keyboard.consumeLastPressedKey();
                if (this.selectedItem > 0) {
                    this.selectedItem--;
                }
                break;

            case KeyEvent.VK_DOWN:
                this.keyboard.consumeLastPressedKey();
                if (this.selectedItem < this.items.size() - 1) {
                    this.selectedItem++;
                }
                break;

            case KeyEvent.VK_ENTER:
                this.keyboard.consumeLastPressedKey();
                switch (selectedItem) {
                    case 0:
                        this.setGameMode(new PlayGM());
                        break;

                    case 1:
//                        this.setGameMode(this.getMenuFactory().getMenuItems(OptionMenuGM.class));
                        break;

                    case 2:
                        this.gui.setClosingRequested(true);
                        break;
                }
        }
    }

    @Override
    public void update() {

    }
}
