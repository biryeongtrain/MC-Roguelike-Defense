package kim.biryeong.minigame;

import com.google.gson.JsonParser;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import net.fabricmc.api.ModInitializer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ModMetadataTest {
    @Test
    void metadataIsExpandedAndPointsToTheEntrypoint() throws Exception {
        try (var stream = getClass().getResourceAsStream("/fabric.mod.json")) {
            assertNotNull(stream);
            var json = JsonParser.parseReader(new InputStreamReader(stream, StandardCharsets.UTF_8)).getAsJsonObject();
            assertEquals(MinigameTemplate.MOD_ID, json.get("id").getAsString());
            assertEquals("server", json.get("environment").getAsString());
            assertEquals("26.3", json.getAsJsonObject("depends").get("minecraft").getAsString());
            assertEquals(">=25", json.getAsJsonObject("depends").get("java").getAsString());
            assertFalse(json.toString().contains("${"));
            String entrypoint = json.getAsJsonObject("entrypoints").getAsJsonArray("main").get(0).getAsString();
            assertTrue(ModInitializer.class.isAssignableFrom(Class.forName(entrypoint, false, getClass().getClassLoader())));
        }
    }
}
