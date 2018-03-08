package br.com.ifpb.sd.infra;

import br.com.ifpb.sd.model.Message;
import br.com.ifpb.sd.model.RemoteRef;
import org.json.JSONObject;

/**
 *
 * @author rodrigobento
 */
public class TranslateImpl implements Translate {

    @Override
    public String toJSON(Message msg) {
        JSONObject object = new JSONObject();
        object.put("messageType", msg.getMessageType());
        object.put("requestId", msg.getRequestId());
        object.put("host", msg.getRemoteReference().getHost());
        object.put("port", msg.getRemoteReference().getPort());
        object.put("operationId", msg.getOperationId());
        object.put("arguments", new String(msg.getArguments()));
        return object.toString();
    }

    @Override
    public Message fromJSON(String json) {
        JSONObject object = new JSONObject(json);
        RemoteRef ref = new RemoteRef(object.getString("host"), object.getString("port"));
        Message m = new Message(object.getInt("messageType"), object.getInt("requestId"), ref, 
                object.getInt("operationId"), object.getString("arguments").getBytes());
        return m;
    }
    
}
