package api.player.forge;

import api.player.client.ClientPlayerClassVisitor;
import api.player.server.ServerPlayerClassVisitor;
import net.minecraft.launchwrapper.IClassTransformer;

public class PlayerAPITransformer implements IClassTransformer {

    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals("net.minecraft.client.entity.EntityPlayerSP")) {
            return ClientPlayerClassVisitor.transform(bytes, PlayerAPIPlugin.isObfuscated);
        } else {
            return transformedName.equals("net.minecraft.entity.player.EntityPlayerMP")
                    ? ServerPlayerClassVisitor.transform(bytes, PlayerAPIPlugin.isObfuscated)
                    : bytes;
        }
    }
}
