package fancyfoods.launcher;

import java.util.ServiceLoader;

import org.osgi.framework.launch.FrameworkFactory;

public class DefaultFrameworkFactoryLocator implements FrameworkFactoryLocator {

	@Override
	public FrameworkFactory locate() {
		ServiceLoader<FrameworkFactory> serviceLoader = ServiceLoader
				.load(FrameworkFactory.class);
		return serviceLoader.iterator().next();
	}

}
