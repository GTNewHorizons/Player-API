package api.player.server;

import net.minecraft.entity.player.EntityPlayerMP;

public interface IServerPlayerAPI extends IServerPlayer {
    ServerPlayerAPI getServerPlayerAPI();

    EntityPlayerMP getEntityPlayerMP();
}
