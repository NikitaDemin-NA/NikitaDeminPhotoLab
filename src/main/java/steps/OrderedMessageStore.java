package steps;

import com.consol.citrus.dsl.runner.DefaultTestRunner;
import com.consol.citrus.dsl.runner.TestRunner;
import com.consol.citrus.exceptions.CitrusRuntimeException;
import com.consol.citrus.message.DefaultMessageStore;
import com.consol.citrus.message.Message;

class OrderedMessageStore extends DefaultMessageStore implements SizedMessageStore {
    private static final String MESSAGE_HAS_NOT_CREATED = "Сообщение \"%s\" не было создано ранее";

    public static SizedMessageStore createOrderedMessageStore(TestRunner runner){
        SizedMessageStore messageStore = new OrderedMessageStore();
        ((DefaultTestRunner) runner).getTestContext().setMessageStore(messageStore);
        return messageStore;
    }

    private OrderedMessageStore(){
    }

    public Message getMessage(String messageName){
        if (this.containsKey(messageName)) {
            return super.getMessage(messageName);
        } else {
            throw new CitrusRuntimeException(String.format("Сообщение \"%s\" не было создано ранее", messageName));
        }
    }
}
