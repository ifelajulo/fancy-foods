package fancyfoods.distribution.launcher;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Implementation of the launcher {@link Configuration configuration} based on a {@link Properties properties} file.
 */
public class PropertiesFileConfiguration implements Configuration {

    private final Properties configurationProperties;

    /**
     * Create new configuration from the given configuration file.
     * 
     * @param configFile configuration file
     * @throws IllegalArgumentException if the configuration file is {@code null} or does not exist
     */
    public PropertiesFileConfiguration(File configFile) {
        System.out.println("Loading configuration from [" + configFile.getAbsolutePath() + "]");
        if (!configFile.exists()) {
            throw new IllegalArgumentException("Configuration file [" + configFile.getAbsolutePath()
                    + "] does not exist");
        }
        this.configurationProperties = new Properties();
        try {
            this.configurationProperties.load(new FileReader(configFile));
        } catch (IOException e) {
            throw new IllegalStateException("Error while loading configuration properties from ["
                    + configFile.getAbsolutePath() + "]", e);
        }
    }

    @Override
    public Map<String, String> getFrameworkConfiguration() {
        Map<String, String> frameworkConfiguration = new HashMap<String, String>();
        Enumeration<?> propertyNames = configurationProperties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String key = (String) propertyNames.nextElement();
            if (key.startsWith("org.osgi.framework")) {
                frameworkConfiguration.put(key, configurationProperties.getProperty(key));
            }
        }

        return frameworkConfiguration;
    }

}
