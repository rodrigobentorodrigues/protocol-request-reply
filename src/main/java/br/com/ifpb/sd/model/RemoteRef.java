package br.com.ifpb.sd.model;

/**
 *
 * @author rodrigobento
 */
public class RemoteRef {
    
    private String host;
    private String port;

    public RemoteRef() {}

    public RemoteRef(String host, String port) {
        this.host = host;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "RemoteRef{" + "host=" + host + ", port=" + port + '}';
    }
    
}
