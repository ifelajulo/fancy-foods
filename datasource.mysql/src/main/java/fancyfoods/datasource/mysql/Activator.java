package fancyfoods.datasource.mysql;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ManagedService;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext context) throws Exception {
        Hashtable<String, Object> properties = new Hashtable<String, Object>();
        properties.put(Constants.SERVICE_PID, "fancyfoods.datasource.mysql");
        context.registerService(ManagedService.class.getName(), new ConfigUpdater(), properties);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        // Do nothing
    }

}
