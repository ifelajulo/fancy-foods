package fancyfoods.launcher;

import org.osgi.framework.launch.FrameworkFactory;

public interface FrameworkFactoryLocator {
	
	FrameworkFactory locate();

}
