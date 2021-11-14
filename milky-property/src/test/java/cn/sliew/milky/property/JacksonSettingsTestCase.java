package cn.sliew.milky.property;

import cn.sliew.milky.property.jackson.JacksonSettings;
import cn.sliew.milky.test.MilkyTestCase;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JacksonSettingsTestCase extends MilkyTestCase {

    private JsonNode source;
    private Settings settings;

    @BeforeEach
    private void beforeEach() throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("");
        Path resource = Paths.get(url.toURI());
        Path json = resource.resolve("users.yml");
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        this.source = mapper.readTree(json.toFile());
        this.settings = new JacksonSettings("jackson", source);
    }

    @Test
    void testGet() {
        assertTrue(settings.contains("userName"));

        JsonNode userNameNode = (JsonNode) settings.get("userName");
        assertEquals("7gNaQ%d01800Mz", userNameNode.asText());

        JsonNode addressNode = (JsonNode) settings.get("address");
        assertEquals(4, addressNode.size());
    }

    @Test
    void testSize() {
        assertFalse(settings.isEmpty());
        assertEquals(5, settings.size());
    }

    @Test
    void testKeySet() {
        Set keySet = settings.getKeySet();
        assertFalse(keySet.isEmpty());
        assertEquals(5, keySet.size());

        Set flattenKeySet = settings.getFlattenKeySet();
        assertFalse(flattenKeySet.isEmpty());
        assertEquals(11, flattenKeySet.size());
    }

    @Test
    void testGetAsList() {
        List products = settings.getAsList("products");
        assertEquals(2, products.size());
    }

    @Test
    void testGetAsMap() {
        Map<String, JsonNode> address = settings.getGroups("address");
        assertEquals(4, address.size());
    }

    @Test
    void testGetByPrefix() {
        Settings settingsByPrefix = settings.getByPrefix("address.");
        System.out.println(settingsByPrefix.getKeySet());
    }
}