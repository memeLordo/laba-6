package SetOfCommands;

import ServerOperation.Message;

import static SetOfCommands.CommandsPack.*;

public class Remove extends CommandInput {

    public Remove() {
        super("remove", "remove from the collection one element whose field value is equivalent to the specified");
    }

    @Override
    public String go(Message message) throws NullPointerException {
        setArgument(message);
        isPeopleDataEmptyCheck();
            putPeopleDataUp(getPeople_data()
                    .stream().filter((p) -> ifPersonInCollection(p,(String) argument))
                    .findFirst().orElseGet(null).getId());
            getPeople_data().pop();
            sortPeopleData();
        return "Remove completed.";
    }
}
