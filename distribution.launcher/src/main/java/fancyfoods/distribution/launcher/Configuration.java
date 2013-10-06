package fancyfoods.distribution.launcher;

import java.util.Map;

import org.osgi.framework.launch.FrameworkFactory;

/**
 * Strategy for discovering {@link Launcher launcher's} configuration properties.
 */
public interface Configuration {

    /**
     * Get the subset of configuration properties that are passed to the {@link FrameworkFactory framework factory} .
     * 
     * @return framework configuration properties
     */
    Map<String, String> getFrameworkConfiguration();

}
