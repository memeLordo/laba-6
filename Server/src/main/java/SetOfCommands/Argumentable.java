package SetOfCommands;

import ServerOperation.Message;

public interface Argumentable {
    String go(Message request);

    void setArgument(Message request);
}
