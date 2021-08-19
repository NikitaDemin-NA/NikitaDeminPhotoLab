package steps;

import com.consol.citrus.message.MessageStore;

public interface SizedMessageStore extends MessageStore {
    int size();
}
