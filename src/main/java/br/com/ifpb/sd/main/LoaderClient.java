package br.com.ifpb.sd.main;

import br.com.ifpb.sd.infra.Client;
import br.com.ifpb.sd.model.RemoteRef;

/**
 *
 * @author rodrigobento
 */
public class LoaderClient {
    
    public static void main(String[] args) {
        Client cliente = new Client();
        byte[] doOperation = cliente.doOperation(new RemoteRef("localhost", "1234"), 1, "Teste".getBytes());
        String resposta = new String(doOperation, 0, doOperation.length);
        System.out.println(resposta);
    }
    
}
