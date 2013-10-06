package fancyfoods.distribution.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class Launcher {

    private final Configuration configuration;

    private final FrameworkFactoryLocator frameworkFactoryLocator;

    private final BundleDiscoverer bundleDiscoverer;

    public Launcher(Configuration configuration, FrameworkFactoryLocator frameworkFactoryLocator,
            BundleDiscoverer bundleDiscoverer) {
        this.configuration = configuration;
        this.frameworkFactoryLocator = frameworkFactoryLocator;
        this.bundleDiscoverer = bundleDiscoverer;
    }

    public void launch() throws Exception {
        new WelcomeMessagePrinter().print(System.out);
        FrameworkFactory frameworkFactory = frameworkFactoryLocator.locate();
        Framework framework = frameworkFactory.newFramework(configuration.getFrameworkConfiguration());
        framework.init();

        framework.start();

        BundleContext context = framework.getBundleContext();
        List<File> bundlesToInstall = bundleDiscoverer.discover();
        List<Bundle> bundlesToStart = new ArrayList<Bundle>(bundlesToInstall.size());

        for (File bundleToInstall : bundlesToInstall) {
            String location = String.valueOf(bundleToInstall.toURI().toURL());
            bundlesToStart.add(context.installBundle(location, new FileInputStream(bundleToInstall)));
        }
        for (Bundle bundle : bundlesToStart) {
            try {
                if (bundle.getHeaders().get(Constants.FRAGMENT_HOST) == null) {
                    bundle.start();
                }
            } catch (BundleException e) {
                System.out.println("Error while starting bundle [" + bundle.getSymbolicName() + ":"
                        + bundle.getVersion() + "]");
                e.printStackTrace(System.err);
            }
        }

        framework.waitForStop(0);
    }

    public static void main(String[] args) throws Exception {
        File binDir = new File(".").getCanonicalFile();
        File distributionDir = binDir.getParentFile();
        File bundlesDir = new File(distributionDir, "bundle");
        File configFile = new File(new File(distributionDir, "config"), "fancyfoods.properties");

        Configuration configuration = new PropertiesFileConfiguration(configFile);
        FrameworkFactoryLocator frameworkFactoryLocator = new DefaultFrameworkFactoryLocator();
        BundleDiscoverer bundleDiscoverer = new DefaultBundleDiscoverer(bundlesDir);
        new Launcher(configuration, frameworkFactoryLocator, bundleDiscoverer).launch();
    }

}
