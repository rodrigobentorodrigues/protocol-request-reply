package br.com.ifpb.sd.infra;

import br.com.ifpb.sd.model.Message;
import org.json.JSONObject;

/**
 *
 * @author rodrigobento
 */
public interface Translate {
    
    String toJSON(Message msg);
    Message fromJSON(String json);
    
}
