package kim.biryeong.minigame;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class MinigameTemplate implements ModInitializer {
    public static final String MOD_ID = "minigame-template";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Minigame Template initialized");
    }
}
