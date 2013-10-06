package fancyfoods.distribution.launcher;

import java.io.File;
import java.util.List;

/**
 * Strategy for discovering bundles that should be installed by the application {@link Launcher launcher} on startup.
 */
public interface BundleDiscoverer {

    /**
     * Return the list of bundles to be installed.
     * 
     * @return the list of bundles
     */
    List<File> discover();

}
