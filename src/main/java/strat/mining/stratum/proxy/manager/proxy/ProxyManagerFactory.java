package strat.mining.stratum.proxy.manager.proxy;

import java.util.HashMap;
import java.util.Map;

public class ProxyManagerFactory {

    private static ProxyManagerFactory instance;

    private Map<String, ProxyManagerInterface> proxies;

    private ProxyManagerInterface proxyManager;

    private ProxyManagerFactory() {
        proxies = new HashMap<>();
        proxies.put("ProxyManager", ProxyManager.getInstance());
        proxies.put("MultiConnectProxyManager", MultiConnectProxyManager.getInstance());
    }

    public static ProxyManagerFactory getInstance() {
        if (instance == null) {
            instance = new ProxyManagerFactory();
        }
        return instance;
    }

    public ProxyManagerInterface getProxy(String name) {
        this.proxyManager = proxies.get(name);

        return this.proxyManager;
    }

    public ProxyManagerInterface getProxy() {
        return this.proxyManager;
    }
}
