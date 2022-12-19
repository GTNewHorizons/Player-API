package api.player.forge;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import java.util.Map;

@MCVersion("1.7.10")
@TransformerExclusions("api.player.forge.*")
public class PlayerAPIPlugin implements IFMLLoadingPlugin {

    public static String Version = "GRADLETOKEN_VERSION";
    public static boolean isObfuscated;

    @Override
    public String[] getASMTransformerClass() {
        return new String[]{"api.player.forge.PlayerAPITransformer"};
    }

    @Override
    public String getModContainerClass() {
        return "api.player.forge.PlayerAPIContainer";
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        isObfuscated = (boolean)data.get("runtimeDeobfuscationEnabled");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
