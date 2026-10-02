package eternaljourney;

import arc.Events;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;

public class Main extends Mod {

    @Override
    public void loadContent() {
    }

    @Override
    public void init() {
        Events.on(ClientLoadEvent.class, e -> {
            START.showIntro();
        });
    }
}