package api.player.client;

import net.minecraft.client.entity.EntityPlayerSP;

public interface IClientPlayerAPI extends IClientPlayer {
    ClientPlayerAPI getClientPlayerAPI();

    EntityPlayerSP getEntityPlayerSP();
}
