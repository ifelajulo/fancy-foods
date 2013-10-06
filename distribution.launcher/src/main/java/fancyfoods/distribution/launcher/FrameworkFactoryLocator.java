package fancyfoods.distribution.launcher;

import org.osgi.framework.launch.FrameworkFactory;

public interface FrameworkFactoryLocator {
	
	FrameworkFactory locate();

}
