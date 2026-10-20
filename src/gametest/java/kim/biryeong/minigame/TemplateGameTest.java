package kim.biryeong.minigame;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.chat.Component;

public final class TemplateGameTest {
    @GameTest
    public void templateAndLibrariesLoadOnDedicatedServer(GameTestHelper context) {
        for (String id : new String[]{MinigameTemplate.MOD_ID, "polymer-core", "sgui", "bil", "apel", "minigamelib",
                "gcb-server", "fabric-permissions-api-v0"}) {
            if (!FabricLoader.getInstance().isModLoaded(id)) {
                context.fail(Component.literal("Required mod was not loaded: " + id));
                return;
            }
        }
        context.succeed();
    }
}
