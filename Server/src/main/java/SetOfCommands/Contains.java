package SetOfCommands;

import ServerOperation.Message;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class Contains extends CommandInput {

    public Contains() {
        super("contains", "description");
    }

    @Override
    public String go(Message message) {
        isPeopleDataEmptyCheck();
            getPeople_data().stream().filter(message.getArgument()::equals).forEach(Show::showPerson);
            return coolEdit(Show.getMessage());
    }
}
