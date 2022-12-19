package api.player.forge;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;
import java.util.Collections;

public class PlayerAPIContainer extends DummyModContainer {

    public PlayerAPIContainer() {
        super(createMetadata());
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        return true;
    }

    private static ModMetadata createMetadata() {
        ModMetadata meta = new ModMetadata();
        meta.modId = "PlayerAPI";
        meta.name = "Player API";
        meta.version = PlayerAPIPlugin.Version;
        meta.description = "Player API for Minecraft Forge";
        meta.url = "http://www.minecraftforum.net/topic/738498-";
        meta.authorList = Collections.singletonList("Divisor");
        return meta;
    }
}
