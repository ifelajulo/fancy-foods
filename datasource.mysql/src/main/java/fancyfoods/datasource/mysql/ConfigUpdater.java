package fancyfoods.datasource.mysql;

import java.util.Dictionary;

import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

public class ConfigUpdater implements ManagedService {

    MyApp app;

    @Override
    public void updated(@SuppressWarnings("rawtypes") Dictionary config) throws ConfigurationException {
        if (config == null) {
            return;
        }
        if (app == null) {
            app = new MyApp();
        }
        app.setTitle((String) config.get("title"));
        app.refresh();
    }

}
