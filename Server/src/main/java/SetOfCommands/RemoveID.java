package SetOfCommands;

import ServerOperation.Message;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class RemoveID extends CommandInput {

    public RemoveID() {
        super("removeid", "удалить элемент из коллекции по его id");
    }

    @Override
    public String go(Message message) throws NullPointerException {
        setArgument(message);
        isPeopleDataEmptyCheck();
            putPeopleDataUp(getPeople_data()
                    .stream().filter((p) -> p.getId().equals(argument))
                    .findFirst().orElseGet(null).getId());
            getPeople_data().pop();
            sortPeopleData();
        return "RemoveID completed.";
    }
}
