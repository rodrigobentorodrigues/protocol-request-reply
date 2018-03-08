package br.com.ifpb.sd.infra;

import br.com.ifpb.sd.model.Message;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author rodrigobento
 */
public class Server {
    
    private Translate translate = new TranslateImpl();
    
    public byte[] getRequest(){
        byte[] request = null;
        try {
            int port = 1234;
            DatagramSocket socket = new DatagramSocket(port);
            request = new byte[1024];
            DatagramPacket pack = new DatagramPacket(request, request.length);
            System.out.println("Aguardando a requisição do cliente");
            socket.receive(pack);
            sendReply(request, pack.getAddress(), pack.getPort());
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return request;
    }
    
    public void sendReply(byte[] reply, InetAddress clientHost, int clientPort){
        String request = new String(reply);
        Message msg = translate.fromJSON(request);
        System.out.println(msg.toString());
        try {
            DatagramSocket socket = new DatagramSocket();
            byte[] response = request.getBytes();
            DatagramPacket pack = new DatagramPacket(response, response.length, 
                    clientHost, clientPort);
            socket.send(pack);
            socket.close();
        } catch (SocketException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
