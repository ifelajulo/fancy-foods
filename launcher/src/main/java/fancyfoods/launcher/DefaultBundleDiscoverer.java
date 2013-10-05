package fancyfoods.launcher;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class DefaultBundleDiscoverer implements BundleDiscoverer {

	private final File root;

	public DefaultBundleDiscoverer(File root) {
		this.root = root;
	}

	@Override
	public List<File> discover() {
		System.out.println("Discovering bundles in [" + root.getAbsolutePath()
				+ "]");
		List<File> discoveredBundles = new LinkedList<File>();
		discover(root, discoveredBundles);
		return discoveredBundles;
	}

	private void discover(File file, List<File> aggregate) {
		if (file.isFile()) {
			aggregate.add(file);
		}
		if (file.isDirectory()) {
			discover(file.listFiles(), aggregate);
		}
	}

	private void discover(File[] files, List<File> aggregate) {
		for (int i = 0; i < files.length; i++) {
			discover(files[i], aggregate);
		}
	}

}
