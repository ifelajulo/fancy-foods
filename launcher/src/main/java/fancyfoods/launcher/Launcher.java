package fancyfoods.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class Launcher {

	private final FrameworkFactoryLocator frameworkFactoryLocator;

	private final BundleDiscoverer bundleDiscoverer;

	public Launcher(FrameworkFactoryLocator frameworkFactoryLocator,
			BundleDiscoverer bundleDiscoverer) {
		this.frameworkFactoryLocator = frameworkFactoryLocator;
		this.bundleDiscoverer = bundleDiscoverer;
	}

	public void launch() throws Exception {
		System.out.println("Launching Fancy Foods");
		System.out.println("=====================");
		Map<String, String> configuration = new HashMap<String, String>();
		FrameworkFactory frameworkFactory = frameworkFactoryLocator.locate();
		Framework framework = frameworkFactory.newFramework(configuration);
		framework.init();

		framework.start();

		BundleContext context = framework.getBundleContext();
		List<File> bundlesToInstall = bundleDiscoverer.discover();
		List<Bundle> bundlesToStart = new ArrayList<Bundle>(
				bundlesToInstall.size());

		for (File bundleToInstall : bundlesToInstall) {
			String location = String.valueOf(bundleToInstall.toURI().toURL());
			bundlesToStart.add(context.installBundle(location,
					new FileInputStream(bundleToInstall)));
		}
		for (Bundle bundle : bundlesToStart) {
			bundle.start();
		}

		framework.waitForStop(0);
	}

	public static void main(String[] args) throws Exception {
		File binDir = new File(".").getCanonicalFile();
		File distributionDir = binDir.getParentFile();
		File bundlesDir = new File(distributionDir, "bundle");

		FrameworkFactoryLocator frameworkFactoryLocator = new DefaultFrameworkFactoryLocator();
		BundleDiscoverer bundleDiscoverer = new DefaultBundleDiscoverer(
				bundlesDir);
		new Launcher(frameworkFactoryLocator, bundleDiscoverer).launch();
	}

}
