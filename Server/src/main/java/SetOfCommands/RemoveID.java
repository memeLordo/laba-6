package SetOfCommands;

import java.io.IOException;

import static SetOfCommands.CommandsPack.*;

public class RemoveID extends Command {

    public RemoveID() {
        super("removeid", "удалить элемент из коллекции по его id", true);
    }

    @Override
    public String go() throws NullPointerException, IOException {
        isPeopleDataEmptyCheck();
            putPeopleDataUp(getPeople_data()
                    .stream().filter((p) -> ifPersonInCollection(p, inputCommand))
                    .findFirst().orElseGet(null).getId());
            getPeople_data().pop();
            sortPeopleData();
        return "RemoveID completed.";
    }
}
