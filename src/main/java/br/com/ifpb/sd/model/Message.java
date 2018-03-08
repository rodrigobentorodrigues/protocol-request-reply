package br.com.ifpb.sd.model;

/**
 *
 * @author rodrigobento
 */
public class Message {
    
    private int messageType;
    private int requestId;
    private RemoteRef remoteReference;
    private int OperationId;
    private byte[] arguments;
    
    public Message(){}

    public Message(int messageType, int requestId, RemoteRef remoteReference, int OperationId, byte[] arguments) {
        this.messageType = messageType;
        this.requestId = requestId;
        this.remoteReference = remoteReference;
        this.OperationId = OperationId;
        this.arguments = arguments;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public RemoteRef getRemoteReference() {
        return remoteReference;
    }

    public void setRemoteReference(RemoteRef remoteReference) {
        this.remoteReference = remoteReference;
    }

    public int getOperationId() {
        return OperationId;
    }

    public void setOperationId(int OperationId) {
        this.OperationId = OperationId;
    }

    public byte[] getArguments() {
        return arguments;
    }

    public void setArguments(byte[] arguments) {
        this.arguments = arguments;
    }

    @Override
    public String toString() {
        return "Message{" + "messageType=" + messageType + ", requestId=" + requestId + ", remoteReference=" + remoteReference + ", OperationId=" + OperationId + ", arguments=" + arguments + '}';
    }    
    
}
