import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;

import java.awt.Rectangle;

@ScriptManifest(
        author = "Nico",
        description = "Crafts dragonhide bodies",
        category = Category.CRAFTING,
        version = 1.0,
        name = "Dragonhide Crafter"
)
public class DragonhideCrafter extends AbstractScript {

    private final int BLUE_DRAGON_LEATHER = 2505;
    private final Rectangle MAKE_ALL_RECTANGLE = new Rectangle(110, 408, 60, 30);

    @Override
    public void onStart() {
        /*
        Set up:
            Withdraw quantity: all
            In inventory: 1 needle, a lot of thread
        */
        super.onStart();
    }

    @Override
    public int onLoop() {
        /*
            Click bank
            Click d'hide leather in inventory
            Click blue dragon leather in bank
            Dismiss bank (ESC)
            Click dragon leather in inventory
            Use dragon leather on needle
            Press space
            Wait until done (wait at least 15 secs)
        */
        Rectangle slotBounds1 = getInventory().slotBounds(0);
        Rectangle slotBounds2 = getInventory().slotBounds(1);
        getBank().open();
        sleep(Calculations.random(200, 300));
        getMouse().click(slotBounds1);
        sleep(Calculations.random(400, 500));
        getBank().withdrawAll(BLUE_DRAGON_LEATHER);
        sleep(Calculations.random(200, 300));
        getKeyboard().closeInterfaceWithESC();
        sleep(Calculations.random(400, 500));
        getMouse().click(slotBounds1);
        sleep(Calculations.random(100, 200));
        getMouse().click(slotBounds2);
        sleep(Calculations.random(600, 700));
        getMouse().click(MAKE_ALL_RECTANGLE);
        getMouse().moveMouseOutsideScreen();
        return Calculations.random(15000, 15500);
    }
}
