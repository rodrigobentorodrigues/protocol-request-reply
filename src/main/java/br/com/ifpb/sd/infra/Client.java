package br.com.ifpb.sd.infra;

import br.com.ifpb.sd.model.Message;
import br.com.ifpb.sd.model.RemoteRef;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author rodrigobento
 */
public class Client {
    
    // TODO: Garantir um ID unico para as mensagens e entrega da resposta
    private Translate translate = new TranslateImpl();
    
    public byte[] doOperation(RemoteRef ref, int operationId, byte[] arguments){
        byte[] response = null;
        try {
            // Enviando a mensagem
            DatagramSocket socket = new DatagramSocket();
            InetAddress adress = InetAddress.getByName(ref.getHost());
            int port = Integer.parseInt(ref.getPort());
            
            Message msg = new Message(operationId, 0, ref, operationId, arguments);
            byte[] bytes = translate.toJSON(msg).getBytes();
            
            DatagramPacket pack = new DatagramPacket(bytes, bytes.length, adress, port);
            socket.send(pack);            
            
            // Recebendo a resposta
            response = new byte[1024];
            DatagramPacket packResponse = new DatagramPacket(response, response.length);
            System.out.println("Esperando a resposta do servidor");
            socket.receive(packResponse);
            System.out.println("Messagem recebida");
            // Fechando o socket
            socket.close();
            return packResponse.getData();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        return response;
    }
    
}
