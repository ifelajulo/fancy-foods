package fancyfoods.launcher;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

/**
 * Tests for {@link PropertiesFileConfiguration}.
 */
public class PropertiesFileConfigurationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Rule
    public TemporaryFolder tmpDir = new TemporaryFolder();

    @Test
    public void init_WhenConfigurationFileDoesNotExist_ThrowsIllegalArgumentException() throws Exception {
        File nonExisting = new File(tmpDir.getRoot(), "nonExisting.properties");

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Configuration file [" + nonExisting.getAbsolutePath() + "] does not exist");
        new PropertiesFileConfiguration(nonExisting);
    }

    @Test
    public void getFrameworkConfiguration() throws Exception {
        File configurationFile = getClassPathFile("fancyfoods.properties");
        PropertiesFileConfiguration configuration = new PropertiesFileConfiguration(configurationFile);

        Map<String, String> frameworkConfiguration = configuration.getFrameworkConfiguration();

        assertEquals(2, frameworkConfiguration.size());
        assertEquals("felix/cache", frameworkConfiguration.get("org.osgi.framework.storage"));
        assertEquals("onFirstInit", frameworkConfiguration.get("org.osgi.framework.storage.clean"));
    }

    private File getClassPathFile(String path) {
        return new File(getClass().getResource("/" + path).getFile());
    }

}
