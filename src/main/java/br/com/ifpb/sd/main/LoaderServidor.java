package br.com.ifpb.sd.main;

import br.com.ifpb.sd.infra.Server;

/**
 *
 * @author rodrigobento
 */
public class LoaderServidor {
    
    public static void main(String[] args) {
        Server servidor = new Server();
        servidor.getRequest();
    }
    
}
